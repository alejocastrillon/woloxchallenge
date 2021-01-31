# Wollox Challenge

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)


In this repository I have implemented the solution for the wolox challenge. I have used Spring Boot and for requests to the external rest service I have relied on rest template. To persist the data I have used H2 Database which is a hybrid database and JDBC to make the connection to it.

### Installation

WoloxChallenge requires [JDK and JRE](https://www.oracle.com/co/java/technologies/javase-jdk11-downloads.html) v11+ and Apache Maven to run.

Build and run the project.

```sh
$ cd woloxchallenge
$ mvn package
$ cd target
$ java -jar woloxchallenge-0.0.1-SNAPSHOT.jar
```
And voila, the project is running!!