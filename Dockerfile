# Imagen de Maven con JDK 21 para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Imagen más liviana para ejecutar el .jar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto en Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
