FROM openjdk:8-jre

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/maven-docker/beacon-project-backend.jar

ENTRYPOINT ["java", "-jar", "/opt/maven-docker/beacon-project-backend.jar"]