FROM amazoncorretto:17-alpine-jdk

COPY target/plataforma-eventos.jar app.jar

ENTRYPOINT ["java", "-jar", "plataforma-eventos.jar"]