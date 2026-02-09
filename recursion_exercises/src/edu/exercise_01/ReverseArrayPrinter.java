package edu.exercise_01;

public class ReverseArrayPrinter {

	public void printArray(int[] array, int n) {
		if (n < 0) {
			return;
		}
			System.out.println(array[n]);
			printArray(array, n - 1);
	}
	public static void main(String[] args) {
		ReverseArrayPrinter ex = new ReverseArrayPrinter();
		int [] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		ex.printArray(array, (array.length - 1));
	}

}
