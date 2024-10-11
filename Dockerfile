FROM openjdk:17.0-slim
COPY target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","PlataformaEventosApplication"]