package com.cognizant.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// JUnit 5 test class for Calculator
//
// @Test         - marks a method as a test
// @BeforeEach  - runs before every test method
// @DisplayName - gives a readable name for the test in reports
// assertEquals - checks if two values are equal
// assertTrue   - checks if a condition is true
// assertThrows - checks if an exception is thrown

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // fresh calculator before each test
    }

    @Test
    @DisplayName("Addition - basic case")
    void testAdd() {
        int result = calculator.add(10, 20);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("Subtraction - positive and negative results")
    void testSubtract() {
        assertEquals(5,  calculator.subtract(15, 10));
        assertEquals(-5, calculator.subtract(10, 15));
        assertEquals(0,  calculator.subtract(10, 10));
    }

    @Test
    @DisplayName("Multiplication - including zero and negative")
    void testMultiply() {
        assertEquals(20,  calculator.multiply(4, 5));
        assertEquals(0,   calculator.multiply(0, 5));
        assertEquals(-20, calculator.multiply(-4, 5));
    }

    @Test
    @DisplayName("Division - normal case")
    void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5));
        assertEquals(0.5, calculator.divide(1, 2));
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @DisplayName("isPositive - returns true for positive numbers only")
    void testIsPositive() {
        assertTrue(calculator.isPositive(5));
        assertFalse(calculator.isPositive(-5));
        assertFalse(calculator.isPositive(0));  // 0 is not positive
    }

    @Test
    @DisplayName("isEven - returns true for even numbers")
    void testIsEven() {
        assertTrue(calculator.isEven(4));
        assertTrue(calculator.isEven(0));
        assertFalse(calculator.isEven(3));
        assertFalse(calculator.isEven(-3));
    }
}
