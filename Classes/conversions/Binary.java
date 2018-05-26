package conversions;

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
	public long binaryToDecimal(){
		long decimalVal = 0;
		int strLength = binaryStr.length();

		/*loop through the binary string and add the corresponding
		decimal values to decimalVal*/
		for (int i = 0; i < binaryStr.length(); i++) {
			char c = binaryStr.charAt(i);
			int currDigit = Character.getNumericValue(c);
			decimalVal += (Math.pow(2, strLength-i-1)) * currDigit;
		}

		return decimalVal;
	}
	
	//convert binary to hex
	public String binaryToHex() {
		Decimal myDecimal = new Decimal();
		long decimalRepresentation = binaryToDecimal();
		myDecimal.setDecimalNum(decimalRepresentation);
		String binaryAsHex = myDecimal.decimalToHex();
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