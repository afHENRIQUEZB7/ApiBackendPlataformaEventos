FROM ubuntu:latest AS build

# Instalar OpenJDK y Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copiar el código fuente
COPY . .

# Compilar el proyecto (omitimos filtración si es necesario)
RUN mvn clean package -DskipTests -Pskip-filtering

# Usar una imagen más ligera para ejecutar la aplicación
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copiar el JAR empaquetado
COPY --from=build /target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
