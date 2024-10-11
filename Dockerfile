FROM openjdk:17.0-slim
COPY out/artifacts/plataforma_eventos_jar/plataforma-eventos.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]