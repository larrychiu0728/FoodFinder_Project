# 使用 Java 21 做 build
FROM eclipse-temurin:21-jdk as build

WORKDIR /app

COPY . .

# 解決 Permission denied
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# =============================

# 執行階段
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]