FROM openjdk:15
ADD target/project-0.0.1-SNAPSHOT.jar fast-pages-image.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fast-pages-image.jar"]