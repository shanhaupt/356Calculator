package conversions;

import exceptions.InvalidBinaryException;

public class Binary {
	
	//data members
	private String binaryStr;
	
	//constructors
	public Binary() {
		
	}
	
	public Binary(String binaryStr) {
		this.setBinaryStr(binaryStr);
	}

	//convert binary to decimal
	public long binaryToDecimal() throws InvalidBinaryException{
		long decimalVal = 0;
		int strLength = binaryStr.length();
		try {
			int n = Integer.parseInt(binaryStr, 2);
			/*loop through the binary string and add the corresponding
			decimal values to decimalVal*/
			for (int i = 0; i < binaryStr.length(); i++) {
				char c = binaryStr.charAt(i);
				int currDigit = Character.getNumericValue(c);
				decimalVal += (Math.pow(2, strLength-i-1)) * currDigit;
			}
		}
		catch(NumberFormatException nfe) {
			throw new InvalidBinaryException("Invalid binary number");
		}
		return decimalVal;
	}
	
	//convert binary to hex
	public String binaryToHex() throws InvalidBinaryException{
		String binaryAsHex = "";
		try {
			Decimal myDecimal = new Decimal();
			long decimalRepresentation = binaryToDecimal();
			myDecimal.setDecimalNum(decimalRepresentation);
			binaryAsHex = myDecimal.decimalToHex();
		}
		catch(InvalidBinaryException ibe) {
			System.out.println(ibe.getMessage());
		}
		return binaryAsHex;
	}

	//accessors and mutators
	public String getBinaryStr() {
		return binaryStr;
	}

	public void setBinaryStr(String binaryStr) {
		this.binaryStr = binaryStr;
	}

}