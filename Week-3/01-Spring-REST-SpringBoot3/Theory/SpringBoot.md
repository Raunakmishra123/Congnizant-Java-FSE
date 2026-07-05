# Spring Boot 3 Features

Spring Boot 3 is the major generation of Spring Boot built on top of Spring Framework 6.

## Major Updates in Spring Boot 3

1. **Java 17 Baseline:** Spring Boot 3 requires Java 17 or higher.
2. **Jakarta EE 9/10:** Transitioned packages from `javax.*` to `jakarta.*` namespace.
3. **GraalVM Native Image Support:** Direct ahead-of-time compilation of Spring Boot apps into native executables, resulting in instant startup times and lower memory footprint.
4. **Improved Observability:** Integrated support for Micrometer and distributed tracing.

## Key Starter Dependencies

- `spring-boot-starter-web`: Builds RESTful applications using Spring MVC. Uses Tomcat as default embedded container.
- `spring-boot-starter-data-jpa`: Connects to databases using Hibernate and JPA.
- `spring-boot-starter-security`: Secures endpoints and handles user credentials.
