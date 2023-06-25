# Demo project

## Databases
Database in application is set up in Postgres with flyway-plugin. As the user you have to create new database and in file 
`application.properties` you have to set up this parameters:

```agsl
# DATABASES CONFIG
spring.datasource.url=jdbc:postgresql://localhost:5432/invoice
spring.datasource.username=postgres
spring.datasource.password=root

# FLYWAY CONFIG
spring.flyway.url=jdbc:postgresql://localhost:5432/invoice
spring.flyway.user=postgres
spring.flyway.password=root
spring.flyway.schemas=public
spring.flyway.locations=classpath:sql
```

After the application is successfully built the flyway migrations will create necessary tables used by application.

## Build tool
Application runs in Spring-boot framework with Maven build tool. The command 
`mvn spring-boot:run`

## Swagger
For successful generation of swagger the dependency `springdoc-openapi-starter-webmvc-ui` is used. Through application
the swagger page is generated automatically from controllers. After application is running see the page with: 
`http://localhost:8080/swagger-ui/index.html#/`.