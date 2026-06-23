package com.cognizant.datastructures;

// Big O Notation - a way to measure how fast (or slow) an algorithm is
// as the input size grows.
//
// Think of it like traveling: O(1) is teleporting, O(n) is walking,
// O(n^2) is walking and checking every step twice.

public class BigOAnalysis {

    // O(1) - Constant time: no matter how big the array, this always takes 1 step
    public static int getFirstElement(int[] arr) {
        return arr[0];
    }

    // O(n) - Linear time: we check each element once. More elements = more time.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // not found
    }

    // O(n^2) - Quadratic time: two nested loops. Gets slow fast for large inputs.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // O(log n) - Logarithmic time: we cut the problem in half each time.
    // Binary search on a sorted array.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;  // target is in the right half
            } else {
                right = mid - 1; // target is in the left half
            }
        }
        return -1;
    }

    // O(2^n) - Exponential time: very slow, avoidable with memoization.
    // Example: Fibonacci without caching recalculates many values.
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] sorted = {5, 10, 15, 20, 25};

        System.out.println("First element (O1): " + getFirstElement(arr));
        System.out.println("Linear search for 30: index " + linearSearch(arr, 30));
        System.out.println("Binary search for 15: index " + binarySearch(sorted, 15));
        System.out.println("Fibonacci(8) = " + fibonacci(8));
    }
}

// Quick summary:
// O(1)       - Always fast, like getting item from array by index
// O(log n)   - Cuts input in half each step, like binary search
// O(n)       - One pass through the data, like linear search
// O(n log n) - Fast sorting like merge sort or quick sort
// O(n^2)     - Slow sorting like bubble sort
// O(2^n)     - Very slow, like naive recursive fibonacci
