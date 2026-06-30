# XML Configuration in Spring

Historically, XML was the primary way to configure the Spring IoC container. While annotation-based and Java configuration are more popular today, XML remains important for legacy applications.

## Declaring Beans in XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Defining a simple bean -->
    <bean id="myBean" class="com.example.MyClass" />

</beans>
```

## Injecting Dependencies

### 1. Constructor Injection
Uses the `<constructor-arg>` element.
```xml
<bean id="service" class="com.example.MyService">
    <constructor-arg ref="repository" />
</bean>
```

### 2. Setter Injection
Uses the `<property>` element (which calls matching setter methods).
```xml
<bean id="service" class="com.example.MyService">
    <property name="myRepository" ref="repository" />
</bean>
```
