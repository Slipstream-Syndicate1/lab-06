
#!/usr/bin/env bash
set -euo pipefail
./gradlew javadoc
rm -rf app/javadocs
mkdir -p app/javadocs
cp -r build/docs/javadoc/* app/javadocs/
echo "Javadocs copied to app/javadocs"
