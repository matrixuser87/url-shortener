#!/bin/bash -e

exec java ${JVM_OPTS} -Dspring.profiles.active=${ENV} -jar /opt/url-shortener/libs/backend-1.0.jar
