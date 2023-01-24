FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=guarantee-letter-generator-0.0.1.jar

WORKDIR /usr/share/guarantee-letter-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","guarantee-letter-generator-0.0.1.jar"]