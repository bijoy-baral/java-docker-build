# Task: Create a Docker image for a Java application

A template project to create a Docker image for a Java application.
The example application exposes an HTTP end-point.

The Docker build uses a [multi-stage build setup](https://docs.docker.com/develop/develop-images/multistage-build/)
to minimize the size of the generated Docker image.

# Requirements

Docker must be installed. No need a Java JDK or Maven installed.


# Usage and Demo

**Step 1:** Create the Docker image according to [Dockerfile](Dockerfile).
This step uses Maven to build, test, and package the [Java application](src/main/java/com/docker/App.java)
according to [pom.xml](pom.xml).  The resulting image is 87MB in size.

```shell
# This may take a few minutes.
$ docker build -t docker/java-docker-build:latest .
```

**Step 2:** Start a container for the Docker image.

```shell
$ docker run -p 8123:8123 docker/java-docker-build:latest
```

**Step 3:** Open another terminal and access the example API endpoint.

```shell
$ curl http://localhost:8123/status
{"status": "idle"}
```


# Notes

You can also build, test, package, and run the Java application locally (without Docker)
if you have JDK 8+ and Maven installed.

```shell
# Build, test, package the application locally
$ mvn package

# Run the application locally
$ java -jar target/app.jar
```
