# Primero, especifica la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /opt/app

# Copia el archivo JAR de tu aplicación desde el contexto actual al directorio de trabajo dentro del contenedor
COPY target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Copia el archivo application.properties
COPY src/main/resources/application.properties ./application.properties

# Expone el puerto necesario (ajusta según tu configuración)
EXPOSE 8080

# Define el comando por defecto para ejecutar cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
