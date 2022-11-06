FROM maven:3.8.6-openjdk-11 AS build
COPY ./GoCloudCamp /home/GoCloudCamp
RUN mvn --file /home/GoCloudCamp/pom.xml clean package

