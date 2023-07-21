FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/spring-boot-web.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${pos} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
