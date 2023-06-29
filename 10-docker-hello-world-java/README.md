# Dockerfile Examples

## Docker commands
- docker build -t in28min/hello-world-docker:v1 .


## Dockerfile - 1 - Creating Docker Images

```
FROM openjdk:18.0-slim
COPY target/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Dockerfile - 2 - Build Jar File - Multi Stage
```
FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:18.0-slim
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]

```

## Dockerfile - 3 - Caching

```
FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java	/home/app/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:18.0-slim
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
```


## Docker-4: Build the image using mvn command directly

```
Go to project home and run this command:
$ mvn spring-boot:build-image
```

## Docker-5: Push the image created by `$ mvn spring-boot:build-image` to dockerhub

```
step-1: retag it

Like: $ docker tag <Image1:tag1>  <docker_username>/<docker_repo_name:tag>

Example: 
$ docker tag hello-world-java:0.0.1-SNAPSHOT  arundhwaj/hello-world-docker:v5 D
```