FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=social-food-generator-0.0.1.jar

WORKDIR /usr/share/social-food-generator/documents

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","social-food-generator-0.0.1.jar"]