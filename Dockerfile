FROM adoptopenjdk/openjdk11:alpine-jre
#FROM openjdk:12
ADD target/account-api-0.0.1-SNAPSHOT.jar account-api.jar
#EXPOSE 8081
ENTRYPOINT ["java","-jar","account-api.jar"]
#CMD ["java","-jar","customer-api.jar"]

#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar

#ENTRYPOINT ["java", "-jar", "application.jar"]