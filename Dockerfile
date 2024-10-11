FROM openjdk:17-slim

# Copiar el archivo JAR generado al directorio de la imagen
COPY target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Configurar el punto de entrada para ejecutar el JAR
ENTRYPOINT ["java","-jar","app.jar"]
