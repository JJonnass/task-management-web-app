FROM openjdk:17
EXPOSE 8081
ADD target/ task-master-docker.jar
ENTRYPOINT ["java","-jar","/task-master-docker.jar"]