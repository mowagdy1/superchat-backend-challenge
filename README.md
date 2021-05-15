# superchat-backend-challenge project

This project uses Kotlin, Quarkus, H2, & Hibernate.

## Running the application in dev mode

You can run the application in dev mode using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/superchat-backend-challenge-1.0.0-SNAPSHOT-runner`

## API Documentation

Once the application is started, you can check any of these choices: 

- The OpenAPI documentation at http://localhost:8080/q/openapi
- And Swagger UI documentation is accessible at http://localhost:8080/q/swagger-ui

## Using The Application

At this project, you add contacts. Then you can send messages to any of them.
When you send a message, you can use placeholders that will by substituted at the backend such as: `NAME_PLACEHOLDER`, `EMAIL_PLACEHOLDER` & `BITCOIN_PLACEHOLDER`.

After sending the message, the backend send it to a webhook that you can change it from the `application.properties` file.
