FROM openjdk:8u222-jre

LABEL maintainer="bzn@abv.bg"
LABEL version="1.0.0"

RUN mkdir -p /opt/url-shortener/libs
COPY build/libs/* /opt/url-shortener/libs

COPY entrypoint.sh ./

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080
EXPOSE 9000