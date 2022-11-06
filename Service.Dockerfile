FROM maven:3.8.6-amazoncorretto-8 AS build
#COPY ./Service /home/Service
#COPY ./Service/docker/application.properties /home/Service/src/main/resources/application.properties
RUN mvn --file /home/GoCloudCamp/pom.xml clean packages