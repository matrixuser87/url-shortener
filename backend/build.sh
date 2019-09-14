#!/bin/bash

docker build -t url-shortener/backend:latest .
docker rm url-shortener-backend
docker run -ti --name "url-shortener-backend" url-shortener/backend:latest
