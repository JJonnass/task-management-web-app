FROM openjdk:17
EXPOSE 8081
ARG JAR_FILE=target/task-master-docker.jar
ENTRYPOINT ["java","-jar","/task-master-docker.jar"]