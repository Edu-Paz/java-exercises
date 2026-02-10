package edu.exercise_06;

/**
 * Class to perform recursive searches in arrays.
 */
public class RecursiveSearch {

    /**
     * Public entry point to search for an element in an array.
     * 
     * @param array   The integer array to be searched.
     * @param element The integer value to find.
     * @return        True if the element exists, false otherwise.
     * @throws NullPointerException If the provided array is null.
     */
    public boolean recursiveSearch(int[] array, int element) throws NullPointerException {
        if (array == null) {
            throw new NullPointerException("Array value is null.");
        }
        // Start recursion from the first index (0)
        return recursiveSearch(array, element, 0);
    }

    /**
     * Recursive helper method that traverses the array index by index.
     */
    private boolean recursiveSearch(int[] array, int element, int n) {
        // Base Case 1: End of array reached without finding the element
        if (n >= array.length) {
            return false;
        }
        // Base Case 2: Element found at the current index
        if (array[n] == element) {
            return true;
        }
        // Recursive Step: Check the next position
        return recursiveSearch(array, element, n + 1);
    }
    
    public static void main(String[] args) {
        RecursiveSearch r = new RecursiveSearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        try {
            // Testing with an element that is NOT in the array
            System.out.println("Is element 40 present? " + r.recursiveSearch(array, 40));
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}