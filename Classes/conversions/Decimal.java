package conversions;

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

	//convert decimal to binary
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
