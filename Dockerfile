FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]