package com.cognizant.datastructures;

// Sorting Algorithms - arranging elements in order (ascending or descending)
//
// Bubble Sort   - simple but slow: O(n^2)
// Insertion Sort - good for nearly sorted data: O(n^2)
// Quick Sort    - fast on average: O(n log n)
// Merge Sort    - always O(n log n), stable, needs extra memory

public class Sorting {

    // Bubble Sort: compare adjacent elements, swap if out of order.
    // Keep repeating until no swaps needed = sorted.
    // Like bubbles rising to the surface of water.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp   = arr[j];
                    arr[j]     = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort: pick one element at a time and insert it in the right position.
    // Like sorting playing cards in your hand.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j   = i - 1;

            // Move elements that are greater than key one step ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Quick Sort: pick a pivot element, put smaller elements before it
    // and larger elements after it, then repeat for each side.
    public static void quickSort(int[] arr) {
        if (arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // sort left side
            quickSort(arr, pivotIndex + 1, high); // sort right side
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // use last element as pivot
        int i     = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i]   = arr[j];
                arr[j]   = temp;
            }
        }

        // Place pivot in its correct position
        int temp      = arr[i + 1];
        arr[i + 1]    = arr[high];
        arr[high]     = temp;

        return i + 1;
    }

    // Merge Sort: divide the array into halves, sort each half,
    // then merge them back together.
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int   mid   = arr.length / 2;
        int[] left  = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0,   left,  0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length)  arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Helper to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class SortingTest {

    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90};

        int[] arr1 = original.clone();
        Sorting.bubbleSort(arr1);
        System.out.print("Bubble Sort:    ");
        Sorting.printArray(arr1);

        int[] arr2 = original.clone();
        Sorting.insertionSort(arr2);
        System.out.print("Insertion Sort: ");
        Sorting.printArray(arr2);

        int[] arr3 = original.clone();
        Sorting.quickSort(arr3);
        System.out.print("Quick Sort:     ");
        Sorting.printArray(arr3);

        int[] arr4 = original.clone();
        Sorting.mergeSort(arr4);
        System.out.print("Merge Sort:     ");
        Sorting.printArray(arr4);
    }
}
