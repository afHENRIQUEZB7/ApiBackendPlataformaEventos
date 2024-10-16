# IMAGEN MODELO
FROM eclipse-temurin:17.0.12_7-jdk

# INFORMAR EL PUERTO DONDE SE EJECUTA EL CONTENEDOR (INFORMATIVO)
EXPOSE 8080

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# DAR PERMISOS DE EJECUCIÓN A mvnw
RUN chmod +x mvnw

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/src
COPY ./src/main/resources/application.yml /root/src/main/resources/application.yml

# ASEGURAR PERMISOS CORRECTOS
RUN chmod -R 755 /root

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/target/plataforma-eventos-0.0.1-SNAPSHOT.jar"]
