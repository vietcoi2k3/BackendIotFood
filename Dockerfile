FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:11.0.13-jdk-slim
COPY --from=build /target/pos-0.0.1-SNAPSHOT.jar pos.jar
EXPOSE 8080	
ENTRYPOINT ["java","-jar","demo.jar"]