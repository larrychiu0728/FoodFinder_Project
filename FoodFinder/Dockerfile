# 使用官方 Java 17 JDK 作為 build 基礎
FROM eclipse-temurin:21-jdk as build

WORKDIR /app

# 複製專案檔案
COPY . .

# 使用 Maven Wrapper 打包
RUN ./mvnw clean package -DskipTests

# -------------------------

# 建立執行階段映像
FROM eclipse-temurin:21-jdk

WORKDIR /app

# 從上面的 build 階段複製 jar 檔
COPY --from=build /app/target/*.jar app.jar

# 執行 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "app.jar"]