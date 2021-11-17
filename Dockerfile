FROM openjdk:11
COPY /build/libs/starter-0.0.1-SNAPSHOT.jar /opt/app/
WORKDIR /opt/app
#RUN ./gradlew bootJar
CMD ["java", "-jar", "starter-0.0.1-SNAPSHOT.jar"]
