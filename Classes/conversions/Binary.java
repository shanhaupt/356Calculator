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
	
	//convert signed binary to decimal
	public long signedBinaryToDecimal() throws InvalidBinaryException{
		long decimalVal = 0;
		
		//number is negative
		if(binaryStr.charAt(0) == '1') {
			StringBuilder modifiedResult = new StringBuilder(binaryStr);
			
			//invert the binary string
			for(int i = 0; i < binaryStr.length(); i++) {
				if(binaryStr.charAt(i) == '0') {
					modifiedResult.setCharAt(i, '1');
				}
				else if(binaryStr.charAt(i) == '1') {
					modifiedResult.setCharAt(i, '0');
				}
			}
			String result = modifiedResult.toString();
			
			String signedBinary = "";
			String carryOver = "0";
			
			//add 1 to the flipped string
			String currNum = result.substring(result.length() -1);
			int currNumInt = Integer.parseInt(currNum);
			int sum = currNumInt + 1;
			if(sum == 1) {
				signedBinary += sum;
			}
			else if(sum == 2) {
				signedBinary += '0';
				carryOver = "1";
			}
			int carryOverInt = 0;
			
			//loop through the binary string summing it up 
			for(int j = result.length() - 2; j > 0; j--) {
				currNum = result.substring(j, j+1);
				currNumInt = Integer.parseInt(currNum);
				carryOverInt = Integer.parseInt(carryOver);
				sum = currNumInt + carryOverInt;
				if(sum == 1) {
					signedBinary += sum;
					carryOver = "0";
				}
				else if(sum == 2) {
					signedBinary += '0';
					carryOver = "1";
				}
			}
			//convert to decimal and multiply by -1
			Binary bin = new Binary(signedBinary);
			return bin.binaryToDecimal() * -1;
		}
		
		//number is positive
		else {
			return binaryToDecimal();
		}
	}
	
	//convert signed binary to hex
	public String signedBinaryToHex(){
		String hex = "";
		try{
			hex += binaryToHex();
		} 
		catch (InvalidBinaryException e){
			e.printStackTrace();
		}
		return hex;
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