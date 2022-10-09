Spring Boot REST API example
=====

This repository is an example application for the Spring Boot framework.
The example is a REST API server in Java.

This repository shows the following features:
* Controllers
* JDBC



Random Book
----

Random Book wants to promote reading by proposing to read a random book of a given category. 
Readings made by users are tracked, and each book can be rated.



Starting the example
----

The example requires Java 17 and PostgreSQL 14.

Create a PostgreSQL database, using the database name, username, and password contained in `application.properties`. 

Run the application in an IDE using its main class or using Gradle: 

```
./gradlew bootRun
```

Interact with the application on http://localhost:8080.




API Documentation
----

To view the API Documentation, run the code and navigate to http://localhost:8080/swagger-ui.html
