# Spring Boot Introduction

Spring Boot is an extension of the Spring framework that simplifies application setup, configuration, and deployment.

## Core Features

1. **Auto-Configuration:** Inspects classpath dependencies and automatically configures beans for you (e.g., configures DataSource if an H2 dependency is present).
2. **Starter Dependencies:** Convenient dependency bundles (e.g., `spring-boot-starter-web` pulls in Spring MVC, Tomcat, Jackson, etc.).
3. **Embedded Web Servers:** Allows you to run applications directly as JARs (includes built-in Tomcat/Jetty).
4. **Actuator:** Built-in endpoints for monitoring and managing your application in production.
