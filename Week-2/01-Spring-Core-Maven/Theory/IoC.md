# Inversion of Control (IoC)

Inversion of Control (IoC) is a design principle where the control of object creation and lifecycle management is transferred from the application code to a container or framework.

## Why Inversion of Control?

- **Decoupling:** Classes are not responsible for instantiating their dependencies.
- **Testability:** Easy to swap real implementations with mock objects for testing.
- **Maintainability:** Changes to instantiation logic are isolated in one configuration place.

## The IoC Container in Spring

In Spring, the IoC Container manages the application's components. It reads configuration metadata (XML, annotations, or Java class config) and builds the application.

Spring provides two main types of containers:

1. **BeanFactory:** The most basic container, providing lightweight configuration management. Good for resource-constrained environments.
2. **ApplicationContext:** Extends BeanFactory. Adds enterprise-specific features like internationalization, event publishing, and automatic integration with Spring AOP. This is the recommended container for most applications.
