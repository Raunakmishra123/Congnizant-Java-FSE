# Spring Framework Notes

Spring is a Java framework that makes building Java applications easier.
The core idea is that Spring manages your objects (beans) for you.

## What is a Bean?

A Bean is just a Java object that Spring creates and manages.
Instead of you doing `BookService service = new BookService()`,
Spring does it for you and gives it to you when needed.

## IoC - Inversion of Control

Normally: Your code creates objects.
With Spring: Spring creates objects and gives them to your code.
This is called "Inversion of Control" - control is flipped.

## Dependency Injection

When class A needs class B to work, we say A depends on B.
Instead of A creating B itself, Spring injects B into A.

```java
// Without DI - A creates B itself (bad - tightly coupled)
class A {
    private B b = new B();
}

// With DI - Spring injects B into A (good - loosely coupled)
class A {
    private B b;

    public A(B b) {
        this.b = b; // B is injected via constructor
    }
}
```

## Types of DI

1. **Constructor Injection** - pass dependencies through constructor (recommended)
2. **Setter Injection** - use setter methods to set dependencies
3. **Field Injection** - use @Autowired on fields (convenient but harder to test)
