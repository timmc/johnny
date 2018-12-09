#!/bin/bash
# Perform code generation -- create parsers from grammars using ANTLR.

set -eu -o pipefail

dest=src/main/generated-java/org/timmc/johnny/internal/gen/parse

if [[ ! -d "$dest" ]]; then
    echo "Must run code generation from johnny project root"
    exit 1
fi

# Clear out whatever we built last time
rm -f "$dest/"*.java

function java_run {
    # Ask Leiningen to set up the classpath
    java -cp "$(lein cp)" "$@"
}

function antlr_build {
    java_run org.antlr.v4.Tool \
        -no-listener -no-visitor -Xexact-output-dir \
        -o "$dest/" -package org.timmc.johnny.internal.gen.parse "$1"
}

antlr_build src/main/grammar/RFC_3986_6874.g4

# Clean up intermediate compilation files
rm "$dest/"*.{interp,tokens}
