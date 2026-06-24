package com.cognizant.datastructures;

// Searching Algorithms - finding an element in a collection
//
// Two main types:
//   Linear Search - check every element one by one (works on any array)
//   Binary Search - cut the search area in half each time (only works on SORTED arrays)

public class Searching {

    // Linear Search - O(n)
    // Start from the first element and check each one.
    // Worst case: element is at the end or not present.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

    // Binary Search - O(log n) but ONLY works on SORTED arrays!
    // We look at the middle element. If target is bigger, search right half.
    // If smaller, search left half. Repeat until found or no elements left.
    public static int binarySearch(int[] arr, int target) {
        int left  = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids overflow compared to (left+right)/2

            if (arr[mid] == target) {
                return mid; // found!
            } else if (arr[mid] < target) {
                left = mid + 1; // target is bigger, look at right side
            } else {
                right = mid - 1; // target is smaller, look at left side
            }
        }

        return -1; // not found
    }

    // Binary Search - recursive version (same logic, different style)
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // base case: search space is empty
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
}

class SearchingTest {

    public static void main(String[] args) {
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        int[] sorted   = {11, 12, 22, 25, 34, 64, 90};

        System.out.println("=== Linear Search ===");
        System.out.println("Search 25 in unsorted array: index " + Searching.linearSearch(unsorted, 25));
        System.out.println("Search 100 (not present): index " + Searching.linearSearch(unsorted, 100));

        System.out.println("\n=== Binary Search (iterative) ===");
        System.out.println("Search 25 in sorted array: index " + Searching.binarySearch(sorted, 25));
        System.out.println("Search 100 (not present): index " + Searching.binarySearch(sorted, 100));

        System.out.println("\n=== Binary Search (recursive) ===");
        System.out.println("Search 64 in sorted array: index " + Searching.binarySearchRecursive(sorted, 64, 0, sorted.length - 1));

        System.out.println("\n=== Performance Comparison ===");
        int size = 1_000_000;
        System.out.println("Array size: " + size);
        System.out.println("Linear Search worst case: " + size + " comparisons");
        System.out.println("Binary Search worst case: " + (int)(Math.log(size) / Math.log(2)) + " comparisons");
    }
}
