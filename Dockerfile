FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} exchange-rate.jar
ENTRYPOINT ["java","-jar","/exchange-rate.jar"]