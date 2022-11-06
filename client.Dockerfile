FROM maven:3.8.6-openjdk-11
COPY ./Client /home/Client
RUN mvn --file /home/Client/pom.xml clean package
CMD java -jar /home/Client/target/grpc-hello-server-1.0-SNAPSHOT.jar