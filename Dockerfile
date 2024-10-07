FROM maven:3.9.9-amazoncorretto-17 AS build

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM amazoncorretto:17

COPY --from=build /target/apirest-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED", "-jar", "/app.jar"]