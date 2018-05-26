
public class Binary {
	
	//data members
	private String binaryStr;
	
	//constructor
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

	//accessors and mutators
	public String getBinaryStr() {
		return binaryStr;
	}

	public void setBinaryStr(String binaryStr) {
		this.binaryStr = binaryStr;
	}

}