package edu.exercise_05;

/**
 * Class providing functionality to convert binary strings to decimal integers.
 */
public class BinaryConverter {

    /**
     * Entry point for the binary to decimal conversion.
     * Validates input length before starting the recursion.
     * 
     * @param binary The 8-digit binary string to convert.
     * @return The decimal representation of the binary string.
     * @throws IllegalArgumentException If the string length is not exactly 8.
     */
    public int binaryToDecimal(String binary) throws IllegalArgumentException {
        // Validation: ensures the input meets the 8-digit requirement
        if (binary.length() != 8) {
            throw new IllegalArgumentException("Binary string must have exactly 8 digits.");
        }
        
        // Start recursion from the last character (index 7) with exponent 0
        return binaryToDecimal(binary.length() - 1, binary, 0, 0);
    }

    /**
     * Recursive helper method that calculates the decimal value bit by bit.
     * 
     * @param position Current index being processed in the string.
     * @param binary The source binary string.
     * @param exponent The power of 2 for the current position.
     * @param value Helper variable to store calculated power.
     * @return The accumulated decimal value.
     */
    private int binaryToDecimal(int position, String binary, double exponent, double value) {
        // Base Case: If position is less than 0, we have processed the entire string
        if (position < 0) {
            return 0;
        }

        // If the current bit is '1', calculate 2^exponent and add to the result
        if (binary.charAt(position) == '1') {
            value = (int) Math.pow(2, exponent);
            return (int) (value + binaryToDecimal(position - 1, binary, exponent + 1, value));
        }
        
        // If the current bit is '0', add 0 to the result and continue
        if (binary.charAt(position) == '0') {
            return (0 + binaryToDecimal(position - 1, binary, exponent + 1, value));
        } else {
            // Safety fallback for characters that are neither '1' nor '0'
            return 0;
        }
    }
    
    public static void main(String[] args) {
        try {
            BinaryConverter converter = new BinaryConverter();
            
            // Test case: 11010001 (Decimal: 209)
            String test = "11010001";
            
            System.out.println("Binary: " + test);
            System.out.println("Decimal result: " + converter.binaryToDecimal(test));
            
        } catch (IllegalArgumentException e) {
            // Log the error message to the error stream
            System.err.println("Error: " + e.getMessage());
        }
    }
}