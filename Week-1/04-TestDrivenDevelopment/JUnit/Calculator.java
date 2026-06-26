package com.cognizant.testing;

// A simple Calculator class that we'll use to learn unit testing with JUnit.
// The idea of TDD (Test Driven Development) is to write tests BEFORE writing code.

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}
