package conversions; 

import exceptions.InvalidBinaryException;

public class Decimal {
	
	//data members
	private long decimalNum;
		
	//constructors
	public Decimal() {
		
	}
	
	public Decimal(long decimalNum) {
		this.setDecimalNum(decimalNum);
	}
	
	//convert decimal to hex
	public String decimalToHex() {
		String hexString = "";
		long result = decimalNum;
		long remainder;
		if(result == 0) {
			hexString += '0';
		}
		
		while(result>0) {
			remainder = result%16;
			result = result/16;
			if(remainder==10) {
				hexString +='A';
			}
			else if(remainder==11) {
				hexString +='B';
			}
			else if(remainder==12) {
				hexString +='C';
			}
			else if(remainder==13) {
				hexString +='D';
			}
			else if(remainder==14) {
				hexString +='E';
			}
			else if(remainder==15) {
				hexString +='F';
			}
			else {
				hexString = hexString+(char) (remainder+48);
			}
		}
		
		hexString = reverseString(hexString);
		
		return hexString;
		
	}

	//convert unsigned decimal to binary
	public String decimalToBinary() {
		String binaryStr = "";
		long tempVal = decimalNum;
		/*divide the decimal value by 2, append the remainder to the binary string
		as long as the decimal value is greater than 0 */
		while(tempVal > 0) {
			long remainder = tempVal - ((tempVal/2)*2);
			binaryStr += remainder;
			tempVal = tempVal/2;
		}

		binaryStr = reverseString(binaryStr);
		
		return binaryStr;
	}
	
	//convert signed decimal to binary
	public String signedDecimalToBinary() {
		long absval = Math.abs(decimalNum);
		
		if(decimalNum<0) {
			boolean foundMSB = false;
			
			int bitPlace = 0;
			int sizeOfArray = 0;
			double MSBDecimalValue = 1;
			
			while(foundMSB == false) {
				double currentMSB = Math.pow(2,  bitPlace);
				if (currentMSB >= absval){
					sizeOfArray=bitPlace+1;
					
					bitPlace -= 1;
					foundMSB = true;
					MSBDecimalValue = currentMSB;
				}
				else {
					bitPlace += 1;
				}
			}
			
			char[] bitRepresentation = new char[sizeOfArray];
			bitRepresentation[sizeOfArray-1] = '1';
			double remainingDecimal = MSBDecimalValue - absval;
			
			while(bitPlace >= 0) {
				double tempNextBit_decimalValue = Math.pow(2,  bitPlace);
				if (tempNextBit_decimalValue <= remainingDecimal) {
					bitRepresentation[bitPlace] = '1';
					remainingDecimal = remainingDecimal-tempNextBit_decimalValue;
				}
				else {
					bitRepresentation[bitPlace] = '0';
				}
				bitPlace -= 1;
			}
			
			return reverseString(String.valueOf(bitRepresentation));
		}
		else {
			return ("0" + this.decimalToBinary());
		}
	}
	
	//convert signed decimal to hex
	public String signedDecimalToHex() {
		Binary binary = new Binary(this.signedDecimalToBinary());
		String hex = "";
		try {
			hex += binary.binaryToHex();
		} catch (InvalidBinaryException e) {
			e.printStackTrace();
		}
		return hex;
	}
	
	//string reverse
	public String reverseString(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb = sb.reverse();
		input = sb.toString();
		return input;
	}

	//accessors and mutators
	public long getDecimalNum() {
		return decimalNum;
	}

	public void setDecimalNum(long decimalNum) {
		this.decimalNum = decimalNum;
	}
}
