FROM eclipse-temurin:17
WORKDIR /app
COPY target/spammer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]