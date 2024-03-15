# Maven
## Create a Maven Project
`mvn archetype:generate -DgroupId=myscrapper.app -DartifactId=static-scrapper -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`

## Compile the 
`mvn compile`

## Create a JAR
`mvn package`
Clean create:
    - `mvn clear package`
    - `mvn clear verify`: does more verification

## Run the JAR
java -cp target/static-scrapper-1.0-SNAPSHOT.jar myscrapper.app.App


# Docker
## Share files between services in docker-compose
1) Write files only within Docker i.e. not persistently

You can mount a volume from the "A" service into the "B" service. This way, any files produced by the "A" service will be accessible to the "B" service.
`
services:
  maven:
    ...
    volumes:
      - maven_data:/data

  python:
    ...
    volumes:
      - maven_data:/data

volumes:
  maven_data:
`

2) Use shared directory - data will be persisted outside Docker
Mount a shared directory from your host machine into both services.
`
version: '3.9'

services:
  maven:
    ...
    volumes:
      - ./maven_data:/data

  python:
    ...
    volumes:
      - ./maven_data:/data
`

# Git
