package edu.exercise_04;

public class BinaryConverter {
	public int binaryToDecimal(String binary) throws IllegalArgumentException{
		if(binary.length() != 8) {
			throw new IllegalArgumentException("Binary string must have exactly 8 digits.");
		}
		
		return binaryToDecimal(binary.length() - 1, binary, 0, 0);
	}
	private int binaryToDecimal(int position, String binary, double exponent, double value) {
		if(position < 0 ) {
			return 0;
		}
		if(binary.charAt(position) == '1') {
			value = (int) Math.pow(2, exponent);
			return (int) (value + binaryToDecimal(position - 1, binary, exponent + 1, value));
		}
		if(binary.charAt(position) == '0') {
			return (0 + binaryToDecimal(position - 1, binary, exponent + 1, value));
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		try{
			BinaryConverter converter = new BinaryConverter();
			
			String test = "11010001";
			
			System.out.println(converter.binaryToDecimal(test));
		}catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
