#!/bin/sh

# $Id: codecover.sh 2259 2007-11-01 13:36:46Z schellrt $

EXEC="$0"
POS="${EXEC%/*}"

exec java -Xmx512M -jar "$POS/lib/codecover-batch.jar" "$@"
