# Spring Beans

In Spring, a **Bean** is any object that is instantiated, assembled, and managed by the Spring IoC container. 

## Key Characteristics of Beans

1. **Managed by Spring:** You don't create beans using the `new` keyword in application code; the container does it for you.
2. **Metadata Driven:** Beans are created based on the configuration metadata (XML, annotations, or Java code) you supply to the container.
3. **POJO-based:** Beans are typically Plain Old Java Objects (POJOs) that don't need to inherit from specialized framework classes.

## How to Define Beans

### 1. XML Configuration
```xml
<bean id="myService" class="com.example.MyService" />
```

### 2. Annotation-based
Using stereotype annotations on the class definition:
```java
@Component
public class MyService {
    // ...
}
```

### 3. Java Configuration
Using `@Configuration` and `@Bean` methods:
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```
