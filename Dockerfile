FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/Blarne/sample-project
WORKDIR /app/sample-project

FROM maven:3-jdk-11-slim as build
WORKDIR /app
COPY --from=clone /app/sample-project /app
RUN mvn install

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/sample-project-1.0.0-SNAPSHOT.jar /app

EXPOSE 8080
ENTRYPOINT ["sh", "-c"]

CMD ["java -jar sample-project-1.0.0-SNAPSHOT.jar"]
