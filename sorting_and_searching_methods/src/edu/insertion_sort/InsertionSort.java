package edu.insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // Store the value to be positioned
            int currentValue = array[i];
            
            // Pointer to the element immediately to the left
            int leftIndex = i - 1;
            
            // While we haven't reached the start of the array AND 
            // the value on the left is greater than our current value
            while (leftIndex >= 0 && array[leftIndex] > currentValue) {
                // Shift the larger value one position to the right
                array[leftIndex + 1] = array[leftIndex];
                
                // Move the pointer one step further to the left
                leftIndex = leftIndex - 1;
            }
            
            // When the loop stops, we've found the insertion point.
            // Insert the current value into the "gap" created.
            array[leftIndex + 1] = currentValue;
        }
        return array;
    }

    public static void main(String[] args) {
        // Create an instance of the class to call the non-static method
        InsertionSort sorter = new InsertionSort();
        
        // Example array
        int[] data = {12, 11, 13, 5, 6, 31, 2};
        
        System.out.println("Original array: " + Arrays.toString(data));
        
        // Sorting
        sorter.insertionSort(data);
        
        System.out.println("Sorted array:   " + Arrays.toString(data));
    }
}