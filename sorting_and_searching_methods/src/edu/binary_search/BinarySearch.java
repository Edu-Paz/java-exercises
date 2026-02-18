package edu.binary_search;

import java.util.Arrays;

/**
 * Class that implements and visualizes the Binary Search algorithm.
 */
public class BinarySearch {

    /**
     * Searches for a target in a sorted array and prints each step of the process.
     * 
     * @param array  The sorted array to search.
     * @param target The value to find.
     * @return       The index of the target, or -1 if not found.
     */
    public int binarySearch(int[] array, int target) {
        int leftSide = 0;
        int rightSide = array.length - 1;
        int step = 1; // Counter to track the number of iterations

        System.out.println("Searching for: " + target);
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("--------------------------------------------------");

        // Loop continues as long as the search range is valid (pointers don't cross)
        while (leftSide <= rightSide) {
            // Calculate middle index avoiding potential integer overflow
            int middle = leftSide + ((rightSide - leftSide) / 2);
            int middleValue = array[middle];

            // Debugging / Visualization output for the current step
            System.out.printf("Step %d:%n", step++);
            System.out.printf("  Range: [index %d to %d]%n", leftSide, rightSide);
            System.out.printf("  Middle index: %d (Value: %d)%n", middle, middleValue);

            // Case 1: Target value found
            if (middleValue == target) {
                System.out.println("  >> MATCH FOUND at index " + middle + "!");
                return middle;
            }

            // Case 2: Current middle value is too small, search the right half
            if (middleValue < target) {
                System.out.println("  >> " + middleValue + " is smaller than target. Discarding left half.");
                leftSide = middle + 1;
            } 
            
            // Case 3: Current middle value is too large, search the left half
            if (middleValue > target){
                System.out.println("  >> " + middleValue + " is greater than target. Discarding right half.");
                rightSide = middle - 1;
            }
            System.out.println(); // Blank line for better log readability
        }

        // Target was not found after the search window collapsed
        System.out.println("Target " + target + " not found in the array.");
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        // Sample sorted dataset
        int[] sortedData = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        
        int result = bs.binarySearch(sortedData, target);
        
        if (result != -1) {
            System.out.println("--------------------------------------------------");
            System.out.println("Final Result: Value found at index " + result);
        }
    }
}
