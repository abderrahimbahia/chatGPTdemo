FROM openjdk:8
EXPOSE 8080
ADD targer/devops-integration.jar devops-integration.jar
ENTRYPOINT ["java", "-jar", "devops-integration.jar"]