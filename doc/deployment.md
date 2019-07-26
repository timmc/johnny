# Deployment

Instructions for releasing a version of Johnny.

TODO: Update for Maven.

## If `lein deploy` works for you

...then use `lein deploy`.

But perhaps you're having GPG issues, in which case...

## Otherwise...

```bash
lein change version leiningen.release/bump-version release
lein vcs commit
# lein vcs tag requires gpg-agent, which is broken for me right now
git tag -u FEEE9B73 johnny-0.1.0
git push
lein do clean, deploy
git push origin --tags
```

## Test the staging repo

The staging repository is now:

https://oss.sonatype.org/service/local/repositories/orgtimmc-1001/content

or similar. Test it out in a project. In a Leiningen project, this
looks like:

```clojure
:repositories
{"timmc-testing"
 {:url "https://oss.sonatype.org/service/local/repositories/orgtimmc-1001/content"
  :releases true
  :snapshots false}}
```

## Release

Now "close" the repo, and "release" it.

## Post-release

- Update the changelog
- Update the README ("Get it" and "Usage" sections)
