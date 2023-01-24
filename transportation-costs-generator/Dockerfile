FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=transportation-costs-generator-0.0.1.jar

WORKDIR /usr/share/transportation-costs-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","transportation-costs-generator-0.0.1.jar"]