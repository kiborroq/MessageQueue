#!bin/bash

# Set local repo directory
export SCRIPT=$(realpath "$0")
export REPO_DIR=$(dirname "$SCRIPT")/local-repo

# Build common-generator package and install into local maven repository
mvn -f common-generator/pom.xml clean package
mvn install:install-file \
    -Dfile="common-generator/target/common-generator-0.0.1.jar" \
    -DgroupId="edu.school21" \
    -DartifactId="common-generator" \
    -Dversion="0.0.1" \
    -Dpackaging="jar" \
    -DlocalRepositoryPath="${REPO_DIR}"

# Build other packages
mvn -f students-data-producer/pom.xml clean package
mvn -f social-food-generator/pom.xml clean package
mvn -f financial-assistance-generator/pom.xml clean package
mvn -f transportation-costs-generator/pom.xml clean package
mvn -f consent-generator/pom.xml clean package
mvn -f guarantee-letter-generator/pom.xml clean package
mvn -f grant-generator/pom.xml clean package
mvn -f contract-generator/pom.xml clean package

# Run docker container builder
docker compose up