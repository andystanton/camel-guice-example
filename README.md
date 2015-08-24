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
