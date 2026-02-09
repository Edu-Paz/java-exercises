package edu.exercise_02;

public class ArraySum {

	public double somaArray(double[][] array, int x, int y) {
		if(x >= array.length) {
			return 0;
		}
		
		int nextX = x;
		int nextY = y + 1;
		
		if (nextY >= array[x].length) {
			nextX = x + 1;
			nextY = 0;
		}
		
		return array[x][y] + somaArray(array, nextX, nextY);
	}
	public static void main(String[] args) {
		ArraySum ex = new ArraySum();
        double[][] data = {
            {1.5, 2.5},
            {3.0, 4.0}
        };

        double total = ex.somaArray(data, 0, 0);
        System.out.println("The total sum is: " + total);
	}

}
