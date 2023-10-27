FROM openjdk:8
EXPOSE 8030
ADD target/ComplaintManagment-0.0.1-SNAPSHOT.jar ComplaintMS-docker.jar
ENTRYPOINT ["java", "-jar", "ComplaintMS-docker.jar"]