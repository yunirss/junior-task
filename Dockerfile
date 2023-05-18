FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/testshop-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} TestShop.jar
ENTRYPOINT ["java","-jar","TestShop.jar"]