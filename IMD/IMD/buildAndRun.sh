#!/bin/sh
mvn clean package && docker build -t com.arelance/IMD .
docker rm -f IMD || true && docker run -d -p 9080:9080 -p 9443:9443 --name IMD com.arelance/IMD