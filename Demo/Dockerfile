FROM maven:3.8.1-openjdk-11-slim as build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package