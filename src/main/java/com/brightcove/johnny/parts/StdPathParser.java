package com.brightcove.johnny.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.brightcove.johnny.http.Codecs;
import com.brightcove.johnny.http.Urls;

/**
 * Parse a path with all features enabled (path parameters, empty segments).
 */
public class StdPathParser implements PathParser {

    private static final QueryParser paramParser = new NullIsEmptyQueryParser(Pattern.compile(";"));

    @SuppressWarnings("unchecked")
    public Collection<PathSegment> parse(String pathRaw) {
        if (pathRaw.isEmpty() || pathRaw.equals("/")) {
            return Collections.EMPTY_LIST;
        }
        if (pathRaw.startsWith("/")) {
            pathRaw = pathRaw.substring(1);
        }
        List<PathSegment> ret = new ArrayList<PathSegment>();
        for (String piece : pathRaw.split("/")) {
            int firstSemi = piece.indexOf(";");
            String rawText, rawParams;
            if (firstSemi == -1) {
                rawText = piece;
                rawParams = "";
            } else {
                rawText = piece.substring(0, firstSemi);
                rawParams = piece.substring(firstSemi + 1);
            }
            Params params = Urls.DEFAULT_CODECS.emptyParams;
            if (!rawParams.isEmpty()) {
                params = params.appendAll(paramParser.parse(rawParams));
            }
            ret.add(new PathSegment(Codecs.percentDecode(rawText), params));
        }
        return Collections.unmodifiableList(ret);
    }
}
