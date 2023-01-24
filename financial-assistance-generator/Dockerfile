FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=financial-assistance-generator-0.0.1.jar

WORKDIR /usr/share/financial-assistance-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","financial-assistance-generator-0.0.1.jar"]