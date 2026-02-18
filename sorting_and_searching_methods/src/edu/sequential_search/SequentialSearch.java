package edu.sequential_search;

/**
 * Class that implements sequential search algorithms for ordered and unordered arrays.
 */
public class SequentialSearch {

    /**
     * Performs a sequential search on an ORDERED array.
     * It uses an early exit strategy: if the current element is greater than the target,
     * the search stops because the target cannot exist further ahead.
     * 
     * @param array The sorted integer array.
     * @param targetValue The value to search for.
     * @return The index of the value, or -1 if not found.
     */
    public int orderedSequentialSearch(int[] array, int targetValue) {
        // Condition: Continue while index is within bounds AND current value <= target
        for (int i = 0; i < array.length && array[i] <= targetValue; i++) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a sequential search on an UNORDERED array.
     * It must traverse the entire array until the element is found.
     * 
     * @param array The unsorted integer array.
     * @param targetValue The value to search for.
     * @return The index of the value, or -1 if not found.
     */
    public int unorderedSequentialSearch(int[] array, int targetValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequentialSearch searcher = new SequentialSearch();

        // Testing Unordered Search
        int[] unorderedData = {10, 50, 5, 20, 8};
        int target1 = 20;
        int result1 = searcher.unorderedSequentialSearch(unorderedData, target1);
        System.out.println("Unordered Search - Value " + target1 + " found at index: " + result1);

        // Testing Ordered Search
        int[] orderedData = {5, 8, 10, 20, 50}; // Data must be sorted
        int target2 = 10;
        int result2 = searcher.orderedSequentialSearch(orderedData, target2);
        System.out.println("Ordered Search - Value " + target2 + " found at index: " + result2);

        // Testing Early Exit (Searching for a value that doesn't exist)
        int target3 = 9;
        int result3 = searcher.orderedSequentialSearch(orderedData, target3);
        System.out.println("Ordered Search - Value " + target3 + " (not present): " + result3);
    }
}
