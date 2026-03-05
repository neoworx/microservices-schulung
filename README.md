# Overview

This project contains a sample spring-boot app and some admin scripts to set up 
a working environment for the participants of the Microservices training.


# Links

### H2

https://www.baeldung.com/spring-boot-h2-database

### RabbitMQ

https://www.baeldung.com/spring-amqp

```bash
docker run -d -p 5672:5672 -p 443:15672 --name my-rabbit --env RABBITMQ_DEFAULT_USER=myuser --env RABBITMQ_DEFAULT_PASS=secret rabbitmq:3-management
```
