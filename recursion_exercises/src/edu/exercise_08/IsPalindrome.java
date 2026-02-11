package edu.exercise_08;

/**
 * Class to check if a string is a palindrome using a recursive approach.
 */
public class IsPalindrome {

    /**
     * Public entry point to validate if a string is a palindrome.
     * It handles null checks, normalization, and filters non-alphanumeric characters.
     * 
     * @param s The string to be evaluated.
     * @return True if the string is a palindrome, false otherwise.
     */
	public boolean isPalindrome(String s){
        // Basic validation: null, empty, or single-character strings are not considered palindromes here
		if(s == null || s.equals("") || s.length() == 1) {
			return false;
		}
		
        // Normalization: convert to lowercase and remove non-alphanumeric characters using Regex
		return check(s.toLowerCase().replaceAll("\\W", ""));
	}
	
    /**
     * Recursive helper method that compares characters from the outside in.
     * 
     * @param s The cleaned and normalized string.
     * @return True if the substring remains a palindrome.
     */
	private boolean check(String s) {
		// Base Case: If the string has 0 or 1 character left, it is a palindrome
		if(s.length() <= 1) {
			return true;
		}
		
		// If the first and last characters match, proceed to check the inner substring
		if(s.charAt(0) == s.charAt(s.length() - 1)) {
            // Recursive step: strip the first and last characters and check again
			return check(s.substring(1, s.length() - 1));
		}
		
        // If characters don't match, it is not a palindrome
		return false;
	}

	public static void main(String[] args) {
		String ex = "ReNnEr";
		IsPalindrome test = new IsPalindrome();
		
        // Testing with a mixed-case string
		System.out.println("Is '" + ex + "' a palindrome? " + test.isPalindrome(ex));
	}
}
