#!/usr/bin/env bash

echo Building docker image

# Back
VERSION="0.0.1-SNAPSHOT"

echo "jar file:" + target/hazelcast.simple.setup-${VERSION}.jar

IMAGE_NAME=tdg/hazelcast.simple.setup:"$VERSION"

docker build -t "${IMAGE_NAME}" --build-arg JAR_FILE=target/hazelcast.simple.setup-${VERSION}.jar .
