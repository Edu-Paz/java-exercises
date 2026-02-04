package edu.exercise_03;

/**
 * Class containing methods to perform operations on bidimensional arrays (matrices).
 */
public class Exercise_03 {
	 
    /**
     * Entry point for printing the primary diagonal.
     * Validates the matrix before starting the recursion.
     * 
     * @param array The matrix to be processed.
     * @throws IllegalArgumentException If the array is null.
     * @throws MatrixNotPossibleException If the matrix is not square.
     */
	public void printPrimaryDiagonal (int[][] array) throws IllegalArgumentException, MatrixNotPossibleException {
		// Input validation
        if (array == null) throw new IllegalArgumentException("The array cannot be null.");
        
        // Ensure the matrix is square (rows == columns)
		if (array.length != array[0].length) throw new MatrixNotPossibleException();
		
        // Trigger the recursive helper method
		printPrimaryDiagonal(array, 0);
	}
	
    /**
     * Helper recursive method to traverse the primary diagonal.
     * 
     * @param array The matrix to read from.
     * @param i The current index (used for both row and column).
     */
	private void printPrimaryDiagonal(int [][] array, int i) {
		// Base case: stop when the index exceeds matrix boundaries
		if (i >= array.length || i >= array[i].length) {
			return;
		}
        
        // In the primary diagonal, row index always equals column index (i, i)
		System.out.println(array[i][i]);
        
        // Recursive step: move to the next diagonal element
		printPrimaryDiagonal(array, i + 1);
	}
	
	public static void main(String[] args) {
		Exercise_03 ex = new Exercise_03();
		
		int[][] array = {
		        {1, 2, 3, 4},
		        {1, 5, 3, 5},
		        {4, 2, 1, 6},
		        {5, 5, 6, 5}
		    };
            
		try {
			ex.printPrimaryDiagonal(array);
		} catch (MatrixNotPossibleException | IllegalArgumentException e) {
            // Logs the specific error message defined in the exception class
			System.err.println("Error: " + e.getMessage());
		}
	}
}