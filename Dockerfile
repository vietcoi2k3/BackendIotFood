FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY target/pos-0.0.1-SNAPSHOT.war /some/path/in/container

EXPOSE 8080
ENTRYPOINT ["java","-jar","pos.jar"]
