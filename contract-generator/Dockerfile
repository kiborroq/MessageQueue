FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=contract-generator-0.0.1.jar

WORKDIR /usr/share/contract-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","contract-generator-0.0.1.jar"]