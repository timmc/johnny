package org.timmc.johnny

import java.util.regex.Pattern

import org.timmc.johnny.internal.Ascii7Oracle
import org.timmc.johnny.internal.ByCharPercentEncoder
import org.timmc.johnny.internal.Codecs
import org.timmc.johnny.internal.Constants
import java.util.*

/**
 * The path component of a URL, consisting of a series of
 * decoded segments. For example, the path `/foo/bar/ba%2fz/`
 * contains the segments `["foo", "bar", "ba/z"]` and has a flag
 * set indicating the trailing slash.
 *
 * TextPath will attempt to keep itself in normalized form.
 *
 * This implementation of path parsing does *not* respect path parameters.
 */
class TextPath
/**
 * Create a new TextPath from a list of segments.
 * @param segments Non-null list of non-empty decoded segments.
 * @param trailingSlash True if the last segment is followed by a slash
 * (also controls presence of slash in empty path)
 */
private constructor(segments: List<String>, private val trailingSlash: Boolean) {

    /**
     * The sequence of segments in this path. For a path `/foo/bar/`, this
     * would be `["foo", "bar"]`. Non-null (possibly empty) normalized sequence
     * of non-empty segments.
     */
    val segments: List<String> = normComponent(segments)
        get() = Collections.unmodifiableList(field)

    /**
     * Tell whether this path has a trailing slash or not. In the edge case
     * of a path with no segments, this is the difference between the paths
     * `""` and `"/"`.
     */
    fun hasTrailingSlash(): Boolean {
        return trailingSlash
    }

    /**
     * Change whether there is a trailing slash or not.
     */
    fun withTrailingSlash(newValue: Boolean): TextPath {
        return TextPath(segments, newValue)
    }

    /**
     * Append the provided (unencoded) segments to the path. Any traversal
     * segments such as `".."` will be applied.
     * @param more Nullable collection of non-null segments.
     */
    fun addSegments(more: List<String>): TextPath {
        return if (more.isEmpty()) {
            this // leaves trailingSlash alone, too
        } else {
            applyEffect(effectOf(more))
                .withTrailingSlash(false)
        }
    }

    /**
     * Append or replace with the provided path. If the provided string is an
     * absolute path, it will remove any existing segments; if it is relative,
     * it may either append to the existing path, remove some of its segments,
     * or both (performs traversal if ".." segments encountered).
     * @param rawRelative Absolute or relative path.
     */
    @Throws(UriDecodeException::class)
    fun resolveRelative(rawRelative: String): TextPath {
        return applyEffect(effectOf(rawRelative))
    }

    /**
     * Append more segments to a path.
     * @param more Further path segments (not null).
     */
    fun addSegments(more: TextPath): TextPath {
        return addSegments(more.segments)
            .withTrailingSlash(more.hasTrailingSlash())
    }

    /**
     * Add one text segment to a path.
     * @param text Text of the path segment (non-null)
     */
    fun addOneSegment(text: String): TextPath {
        return addSegments(listOf(text))
    }

    /**
     * Format path into a normalized raw path string.
     * @return Raw path string, either empty or starting with "/".
     */
    fun format(): String {
        val ret = StringBuilder()
        for (seg in segments) {
            ret.append('/').append(SEGMENT_ENCODER.encode(seg))
        }
        if (trailingSlash)
            ret.append('/')
        return ret.toString()
    }

    /*== Internals ==*/

    private fun applyEffect(effect: PathEffect): TextPath {
        if (effect.absolute) {
            return TextPath(effect.added, effect.hadTrailingSlash)
        } else {
            var build: MutableList<String> = ArrayList(segments)

            if (effect.backwards > 0) {
                val newSize = Math.max(0, build.size - effect.backwards)
                build = build.subList(0, newSize)
            }

            build.addAll(effect.added)

            val useTrailingSlash = if (effect.added.isEmpty() && effect.backwards == 0) {
                // If nothing was added or removed, don't inherit the effect's
                // trailing slash.
                trailingSlash
            } else {
                effect.hadTrailingSlash
            }
            return TextPath(build, useTrailingSlash)
        }
    }

    //== Object overrides ==//

    override fun equals(other: Any?): Boolean {
        return other is TextPath &&
            trailingSlash == other.trailingSlash &&
            segments == other.segments
    }

    override fun hashCode(): Int {
        return arrayOf(segments, trailingSlash).contentHashCode()
    }

    override fun toString(): String {
        return format()
    }

    companion object {
        /** Encoder for path segments.  */
        private val SEGMENT_ENCODER = ByCharPercentEncoder(Ascii7Oracle(Constants.RFC3986_UNENCODED_PATH_SEGMENT))

        /** Empty path instance.  */
        @JvmField
        val EMPTY = TextPath(emptyList(), false)

        /** Normalize (if necessary).  */
        private fun normComponent(input: List<String>): List<String> {
            return if (!isNormalized(input)) {
                normalize(input)
            } else input
        }

        /**
         * Given a path component, cancel out any empty segments or traversal
         * segments.
         * @param pathComp Path component as sequence of decoded segments.
         * @return Filtered version of component.
         */
        private fun normalize(pathComp: Iterable<String>): List<String> {
            return effectOf(pathComp).added
        }

        /** Match decoded empty or traversal segment.  */
        private val nonNormalSegment = Pattern.compile("\\.{0,2}")

        /**
         * Determine if path component is already normalized.
         * @param pathComp Path component as sequence of decoded segments.
         * @return true iff has no empty segments or traversal segments.
         */
        private fun isNormalized(pathComp: Iterable<String>): Boolean {
            for (seg in pathComp) {
                if (nonNormalSegment.matcher(seg).matches()) {
                    return false
                }
            }
            return true
        }

        /**
         * Same as [effectOf], but accepts a path
         * reference as a string and returns the decoded effect.
         * @param pathRef Path reference, not null.
         * @return Effect on an existing path component, with decoded segments.
         */
        @Throws(UriDecodeException::class)
        private fun effectOf(pathRef: String): PathEffect {
            val absolute = Paths.isAbsolute(pathRef)
            val effect = effectOf(decodeEach(Paths.explodeRaw(pathRef)))
            return PathEffect(
                absolute,
                if (absolute) 0 else effect.backwards,
                effect.added,
                pathRef.endsWith("/")
            )
        }

        /**
         * Compute the effect of applying this relative sequence of decoded path
         * segments to an existing path. This will remove
         * `.` and empty segments and use `..` to backtrack
         * over existing segments.
         * @param pathRefSegs Decoded segments of a path reference. Not null, and
         * segments may not be null.
         * @return Effect on an existing path component, where
         * [PathEffect.added] will be a filtered version of the param
         * `more` (no segments will be altered, only removed.)
         */
        private fun effectOf(pathRefSegs: Iterable<String>): PathEffect {
            var removed = 0
            val added = ArrayList<String>()
            for (seg in pathRefSegs) {
                if (seg.isEmpty() || seg == ".") {
                    continue
                } else if (seg == "..") {
                    if (added.isEmpty()) {
                        removed++
                    } else {
                        added.removeAt(added.size - 1)
                    }
                } else {
                    added.add(seg)
                }
            }
            return PathEffect(false, removed, added, false)
        }

        /** Percent-decode each segment.  */
        @Throws(UriDecodeException::class)
        private fun decodeEach(rawSegs: Iterable<String>): Iterable<String> {
            val build = ArrayList<String>()
            for (raw in rawSegs) {
                build.add(Codecs.percentDecode(raw))
            }
            return Collections.unmodifiableList(build)
        }
    }
}

/**
 * The results of applying a relative path reference to a URI. The effect
 * may either be absolute (replaces entire path, iff [absolute] =
 * true) or relative. If absolute, [added] is the new
 * path. If relative, [backwards] indicates how many existing path
 * segments are to be removed from the old path (if available) before
 * [added] is appended.
 */
internal class PathEffect
/**
 * Create a PathEffect. If param `absolute` is true, param
 * `backward` *should* be zero.
 * @param added Should be immutable
 */
constructor (
    /**
     * True iff entire old path should be replaced by contents of
     * [added].
     */
    val absolute: Boolean,
    backwards: Int,
    /**
     * Elements to append to old path or replace it with. Whether these
     * are raw or decoded path segments is dependent on context. Non-null.
     * Should be immutable.
     */
    val added: List<String>,
    /**
     * Whether or not the reference had a trailing slash. (The absolute
     * empty path "/" is considered to have a trailing slash.)
     */
    val hadTrailingSlash: Boolean
) {
    /**
     * Iff [absolute] is false, remove this many elements from
     * old path before appending [added].
     */
    val backwards: Int = if (absolute) 0 else backwards

    override fun toString(): String {
        return String.format(
            "abs=%s,  back=%s, added=%s, trailingSlash=%s",
            absolute, backwards, added, hadTrailingSlash
        )
    }
}
