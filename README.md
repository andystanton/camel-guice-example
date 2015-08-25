# Camel + Guice Example

An example of how to bootstrap a simple HTTP Server using Camel and Guice in Java 8.

## Requirements

 * Java 8 JDK
 * Maven 3.3.x

## Running the example

#### Clone

```sh
$ git clone https://github.com/andystanton/camel-guice-example.git camel-guice-example
$ cd camel-guice-example
```

#### Build and Run

```sh
$ mvn clean package
$ java -jar target/camel-guice-example-1.0.0.jar
```

#### Verify

```sh
$ curl -i http://127.0.0.1:8080/ping
```

This should return the following response:

```
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
Content-Length: 4
Server: Jetty(8.y.z-SNAPSHOT)

pong
```

## Running the example with Docker

You can build and run the example without needing Java or Maven to be installed locally using Docker:

```sh
$ docker run \
    -w /tmp/camel-guice-example \
    -p 8080:8080 \
    -it \
    --rm \
    maven \
    sh -c 'git clone https://github.com/andystanton/camel-guice-example.git . \
        && mvn clean package \
        && java -jar target/camel-guice-example-1.0.0.jar'
```

The IP address is now that of the Docker Host rather than localhost (assumed to be named 'default' here). If you use Docker Machine to manage your hosts, you can use the following curl command to verify:

```sh
$ curl -i "http://$(docker-machine ip default):8080/ping"
```