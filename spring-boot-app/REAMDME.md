# Step by step

## Initialize Project

Go to https://start.spring.io/

Select dependencies "Spring Web", "Spring Boot Actuator", "Spring Data JPA", "h2"


## Add h2


Add following lines to the `application.properties` file:

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
```

Readings: https://www.baeldung.com/spring-boot-h2-database

## Add Open API / Swagger

Add the following to `dependencies` section of build.gradle

```
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.1'
```

Readings: https://www.baeldung.com/spring-rest-openapi-documentation

## REST Controller

https://www.baeldung.com/spring-controller-vs-restcontroller

Add `controller` package, and there a controller class, annotated `@RestController`.

### Add simple GET method

```java
@GetMapping("/fahrzeuge")
public List<String> getFahrzeuge() {
  return new ArrayList<>();
}
```

## Add repository and model classes


## Rabbit MQ 


## Postgres


## Exception Handling




