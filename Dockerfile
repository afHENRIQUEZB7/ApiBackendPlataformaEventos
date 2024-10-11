FROM amazoncorretto:17-alpine-jdk

COPY out/artifacts/plataforma_eventos_jar/plataforma-eventos.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]