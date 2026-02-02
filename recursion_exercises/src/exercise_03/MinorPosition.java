package exercise_03;

/**
 * Class to find the index of the minimum value in an array using recursion.
 */
public class MinorPosition {

    /**
     * Recursively finds the position of the smallest element.
     * 
     * @param minorValue      The current smallest value found.
     * @param minorPosition   The index of the current smallest value.
     * @param array           The array to be searched.
     * @param actualPosition  The current index being evaluated.
     * @return                The index of the minimum value in the array.
     */
    public int minorPosition(int minorValue, int minorPosition, int[] array, int actualPosition) {
        // Base case: if we've reached the end of the array, return the found position
        if (actualPosition >= array.length) {
            return minorPosition;
        }

        // Check if the current element is smaller than our current minimum


        if (array[actualPosition] < minorValue) {
            minorPosition = actualPosition; // Update minimum position
            minorValue = array[actualPosition]; // Update minimum value
            
            // Recursive call with updated values
            return minorPosition(minorValue, minorPosition, array, actualPosition + 1);
        }

        // Recursive call continuing with the current minimum
        return minorPosition(minorValue, minorPosition, array, actualPosition + 1);
    }
    
    public static void main(String[] args) {
        int[] array = {10, 1, -20, 2, -30, 3, 4, 1, 4, 0, -10};
        MinorPosition ex = new MinorPosition();
        
        // Initial call starting from the first element (index 0)
        System.out.println("The position of the minor value is: " + ex.minorPosition(array[0], 0, array, 0));
    }
}