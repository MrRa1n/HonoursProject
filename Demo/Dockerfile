FROM maven:3.8.1-openjdk-11-slim
WORKDIR /app
COPY pom.xml .
RUN mvn clean dependency:resolve
RUN mvn exec:exec -Dexec.executable="echo"
COPY src/ ./src
RUN mvn compile

#FROM adoptopenjdk/openjdk11:alpine-slim
#COPY --from=build /app/target/adventure_works-0.0.1.jar /usr/app/adventure_works-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["mvn","exec:java"]