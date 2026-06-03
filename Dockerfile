FROM eclipse-temurin:21-jdk-jammy

ADD target/javaexpress-springboot-docker.jar javaexpress-springboot-docker.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","javaexpress-springboot-docker.jar"]
