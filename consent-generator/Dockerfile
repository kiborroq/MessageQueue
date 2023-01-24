FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=consent-generator-0.0.1.jar

WORKDIR /usr/share/consent-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","consent-generator-0.0.1.jar"]