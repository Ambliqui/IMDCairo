@echo off
call mvn clean package
call docker build -t com.arelance/IMD .
call docker rm -f IMD
call docker run -d -p 9080:9080 -p 9443:9443 --name IMD com.arelance/IMD