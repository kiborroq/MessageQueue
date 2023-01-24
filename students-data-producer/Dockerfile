FROM adoptopenjdk/openjdk8:alpine-jre

RUN apk --no-cache add curl

ARG JAR_NAME=students-data-producer-0.0.1.jar

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","students-data-producer-0.0.1.jar"]