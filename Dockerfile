FROM ubuntu:latest AS build

# Instalar OpenJDK y Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copiar el código fuente
COPY . .

# Compilar el proyecto
RUN mvn clean package -DskipTests

# Usar una imagen más ligera para ejecutar la aplicación
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copiar el JAR empaquetado
COPY --from=build /target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
