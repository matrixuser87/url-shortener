# URL shortener.

Running application.
```
./gradlew clean build

docker-compose build

docker-compose up
```

**RabbitMQ**  
[http://localhost:15672/](http://localhost:15672/) - Management console, username: guest , password: guest.

**Spring Actuator endpoints:**
[http://localhost:8080/actuator/](http://localhost:8080/actuator/) - List of all endpoints.  
[http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) - Health endpoint.

**Project endpoints:**  
[http://localhost:8080/](http://localhost:8080/) - send message to RabbitMQ and return greeting.
[http://localhost:8080/jwttest](http://localhost:8080/jwttest) - test oauth2 security.  
  