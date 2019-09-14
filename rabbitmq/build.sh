#!/bin/bash

docker build -t url-shortener/rabbitmq:latest .
docker rm url-shortener-rabbitmq
docker run -ti --name "url-shortener-rabbitmq" url-shortener/rabbitmq:latest