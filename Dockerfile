# Etapa de construcción
FROM maven:3.8.8-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo de configuración de Maven
COPY pom.xml .

# Descargar las dependencias del proyecto
RUN mvn dependency:go-offline -B

# Copiar el resto del código fuente del proyecto
COPY src ./src

# Compilar el proyecto y construir el archivo JAR
RUN mvn package -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Exponer el puerto de la aplicación
EXPOSE 8080

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/plataforma-eventos-0.0.1-SNAPSHOT.jar app.jar

# Definir el punto de entrada del contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
