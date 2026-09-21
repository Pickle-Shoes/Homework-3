package org.example;

import java.util.Random;
import java.util.Vector;

public class Main {

    // Quick Sort Functions from https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/
    // partition function
    static int partition(Vector<Integer> arr, int low, int high) {

        // choose the pivot
        int pivot = arr.get(high);

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(Vector<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    // the QuickSort function implementation
    static void quickSort(Vector<Integer> arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Main
    static void main() {
        // Declaring the vectors
        Vector<Integer> vector = new Vector<>(), sorted = new Vector<>();

        // Initializing variables
        int max = 10;
        int high = 5000;
        int increment = 50000;

        // Creating and sorting the data set
        System.out.println("Creating and sorting data...");
        for (int loop = 1; loop <= max; loop++) {
            vector.setSize(loop * increment);
            for(int fruitLoops = (loop - 1) * increment; fruitLoops < loop * increment; fruitLoops++)
            {
                Random random = new Random();
                vector.set(fruitLoops, random.nextInt(high + 1));
                //vector.add(random.nextInt(high + 1));
            }
            sorted.setSize(loop * increment);
            sorted = vector;

            // Start timing and sorting
            long start = System.nanoTime();
            quickSort(sorted, 0, (loop * increment) - 1);

            // Stop and calculate time
            long end = System.nanoTime();
            long time = (end - start) / 1000000; // Divide by 1,000,000 to convert from nanoseconds to milliseconds
            System.out.println("Data from " + loop + " took " + time + " milliseconds to sort. Data Size: " + increment * loop + ".");
        }
    }
}
