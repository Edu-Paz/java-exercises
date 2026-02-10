package edu.exercise_07;

/**
 * Class to demonstrate string inversion using recursion.
 */
public class InvertedString {

    /**
     * Public entry point to invert a string.
     * 
     * @param string The source string to be inverted.
     * @return The inverted string or an error message.
     * @throws IllegalArgumentException If the string has only one character.
     */
    public String invertString(String string) throws IllegalArgumentException {
        // Validation: Ensure the string is not null or empty before checking length
        if (string == null || string.isEmpty()) {
            return "String is null or empty";
        }
        
        // Requirement-based validation: Throw exception if length is 1
        if (string.length() == 1) {
            throw new IllegalArgumentException("This string contains only one element");
        }
        
        // Start recursion from the last character index
        return invertString(string, string.length() - 1);
    }

    /**
     * Recursive helper method that builds the inverted string.
     * 
     * @param string The original string.
     * @param n Current index being processed (moving backwards).
     * @return The character at 'n' concatenated with the rest of the inverted string.
     */
    private String invertString(String string, int n) {
        // Base Case: If we reach the first character (index 0), stop recursion
        if (n == 0) {
            return String.valueOf(string.charAt(n));
        }
        
        // Recursive Step: Take the current char and append the result of the next call
        return string.charAt(n) + invertString(string, n - 1);
    }

    public static void main(String[] args) {
        String ex = "Unisinos";
        InvertedString is = new InvertedString();
        
        try {
            String inv = is.invertString(ex);
            System.out.println("Original: " + ex);
            System.out.println("Inverted: " + inv);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}