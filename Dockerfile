FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=/target/allegro-last-updated-repo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} allegro-last-updated-repo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/allegro-last-updated-repo.jar"]