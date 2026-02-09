package edu.exercise_04;

public class MatrixNotPossibleException extends Exception {
	private static final long serialVersionUID = 1084881600208528286L;
	public MatrixNotPossibleException() {
        super("Matrix is not a square");
    }
	public String toString() {
		return "Erro: Matrix is not a square";
	}
}
