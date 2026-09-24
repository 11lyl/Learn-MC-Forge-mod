#!/usr/bin/env bash
# ---------------------------------------------------------------------------
# mcrun.sh - headless Minecraft Forge build/test runner for fnOS
#
# Why this script exists:
#  1. This NAS has no display, so runClient cannot work. Use these instead:
#       ./mcrun.sh build              compile + run unit tests
#       ./mcrun.sh test               JUnit unit tests only
#       ./mcrun.sh runGameTestServer  in-world automated GameTests (headless)
#       ./mcrun.sh runData            data generators
#       ./mcrun.sh runServer          headless dedicated server
#  2. Java resolves user.home from /etc/passwd, which points at a directory
#     that does not exist on fnOS. Gradle then fails to create its lock file.
#     We therefore pin GRADLE_USER_HOME into the project directory, which also
#     means any fnOS user can build without owning a writable $HOME.
#  3. Forge 1.20.1 needs a Java 17 toolchain, and fnOS ships the JDKs in
#     /vol1/@appcenter/... rather than a standard location, so Gradle's
#     auto-detection cannot find them. We declare them explicitly.
# ---------------------------------------------------------------------------
set -euo pipefail

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

JDK17=/vol1/@appcenter/java-17-openjdk
JDK21=/vol1/@appcenter/java-21-openjdk

# Forge 1.20.1 targets Java 17; prefer it, fall back to 21 if it is missing.
if [ -x "$JDK17/bin/java" ]; then
  export JAVA_HOME="$JDK17"
elif [ -x "$JDK21/bin/java" ]; then
  export JAVA_HOME="$JDK21"
else
  echo "ERROR: no JDK found under /vol1/@appcenter/" >&2
  exit 1
fi
export PATH="$JAVA_HOME/bin:$PATH"

# Project-local Gradle home: large (several GB) but self-contained and
# writable by every user, regardless of what $HOME resolves to.
export GRADLE_USER_HOME="${GRADLE_USER_HOME:-$PROJECT_DIR/.gradle-home}"
mkdir -p "$GRADLE_USER_HOME"
chmod 777 "$GRADLE_USER_HOME" 2>/dev/null || true

# Teach Gradle where the fnOS JDKs live (needed for the Java 17 toolchain).
TOOLCHAIN_PROPS="$GRADLE_USER_HOME/gradle.properties"
TOOLCHAIN_LINE="org.gradle.java.installations.paths=$JDK17,$JDK21"
if ! grep -qxF "$TOOLCHAIN_LINE" "$TOOLCHAIN_PROPS" 2>/dev/null; then
  printf '%s\n' "$TOOLCHAIN_LINE" >> "$TOOLCHAIN_PROPS"
fi

echo "==> JAVA_HOME        = $JAVA_HOME"
echo "==> GRADLE_USER_HOME = $GRADLE_USER_HOME"
"$JAVA_HOME/bin/java" -version 2>&1 | head -1
echo "==> task: ${*:-build}"
echo

exec ./gradlew "${@:-build}"
