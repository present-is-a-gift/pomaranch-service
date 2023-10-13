@echo off
docker build -t service .
docker run --name service --rm -d -p 8080:8080 service
docker ps -a
docker rmi -f service