# Bean Scopes in Spring

The scope of a bean determines its lifecycle and how many instances are created in the container.

## Standard Scopes

### 1. Singleton (Default)
- Only **one** instance of the bean is created per Spring IoC container.
- All requests for that bean ID will return the exact same shared object instance.
- Best for stateless beans (e.g., Controllers, Services).

### 2. Prototype
- A **new** instance is created every time the bean is requested from the container.
- Best for stateful beans containing mutable data.

## Web-Aware Scopes (Only in WebApplicationContext)

- **Request:** A single instance is created for the lifecycle of a single HTTP request.
- **Session:** A single instance is created for the lifecycle of an HTTP session.
- **Application:** Scoped to the lifecycle of a ServletContext.
- **WebSocket:** Scoped to the lifecycle of a WebSocket.

## How to Configure Scopes

### In XML:
```xml
<bean id="myBean" class="com.example.MyClass" scope="prototype" />
```

### In Java Config/Annotations:
```java
@Component
@Scope("prototype")
public class MyClass {
    // ...
}
```
