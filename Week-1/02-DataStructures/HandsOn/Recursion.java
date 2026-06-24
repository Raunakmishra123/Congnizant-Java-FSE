package com.cognizant.datastructures;

// Recursion means a function calls itself.
// Every recursive function needs:
//   1. A base case  - when to STOP
//   2. A recursive case - call itself with a smaller input
//
// Think of it like opening Russian dolls - each doll opens a smaller one
// until you reach the smallest one (base case).

public class Recursion {

    // Factorial: 5! = 5 * 4 * 3 * 2 * 1 = 120
    // Base case: 0! = 1 and 1! = 1
    public static int factorial(int n) {
        if (n <= 1) {
            return 1; // base case - stop here
        }
        return n * factorial(n - 1); // call itself with n-1
    }

    // Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13...
    // Each number is the sum of the two before it.
    // WARNING: this is O(2^n) without caching - slow for large n
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // base case: fib(0)=0, fib(1)=1
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Fibonacci with memoization - stores results to avoid recalculation
    // Much faster: O(n) instead of O(2^n)
    public static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n]; // already calculated, just return it
        }
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }

    // Calculate a^b (a raised to power b)
    // Example: 2^10 = 1024
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // base case: anything^0 = 1
        }
        return base * power(base, exponent - 1);
    }

    // Sum all elements in an array
    // sumArray([1,2,3,4,5], 0) = 1 + sumArray([2,3,4,5], 1) = ... = 15
    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0; // base case: no more elements
        }
        return arr[index] + sumArray(arr, index + 1);
    }

    // Reverse a string
    // reverse("hello") = "o" + reverse("hell") = "olleh"
    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s; // base case: empty string
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}

class RecursionTest {

    public static void main(String[] args) {
        System.out.println("Factorial of 5 = " + Recursion.factorial(5));    // 120
        System.out.println("Factorial of 0 = " + Recursion.factorial(0));    // 1

        System.out.println("Fibonacci(10) = " + Recursion.fibonacci(10));    // 55

        // Faster fibonacci with memoization
        int[] memo = new int[11];
        for (int i = 0; i < memo.length; i++) memo[i] = -1; // fill with -1 (uncomputed)
        System.out.println("Fibonacci(10) with memo = " + Recursion.fibonacciMemo(10, memo)); // 55

        System.out.println("2^10 = " + Recursion.power(2, 10));              // 1024

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Sum of array = " + Recursion.sumArray(numbers, 0)); // 15

        System.out.println("Reverse of 'hello' = " + Recursion.reverseString("hello")); // olleh
    }
}
