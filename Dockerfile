# Usar la imagen de Maven con OpenJDK 17 para construir el proyecto
FROM maven:3.8.5-openjdk-17 AS build

# Copiar el código fuente al contenedor
COPY . .

# Compilar el proyecto sin pruebas y sin filtración
RUN mvn clean package -DskipTests

# Usar una imagen más ligera para ejecutar la aplicación
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copiar el JAR empaquetado
COPY --from=build /target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
