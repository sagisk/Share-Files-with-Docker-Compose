FROM maven:3.6.0-jdk-8

RUN mkdir /docker

WORKDIR /docker

COPY pom.xml .
# download the dependecies to reuse the cached layer and restart from COPY src . layer (therefore not re-downloading all dependencies)
RUN mvn dependency:resolve 

COPY src ./src

RUN mvn clean verify

CMD java -cp target/static-scrapper-1.0-SNAPSHOT-jar-with-dependencies.jar myscrapper.app.App
# CMD [ "java", "-cp", "target/static-scrapper-1.0-SNAPSHOT.jar", "myscrapper.app.App"]