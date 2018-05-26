
public class Decimal {
	
	//data members
	private long decimalNum;
		
	//constructor
	public Decimal(long decimalNum) {
		this.setDecimalNum(decimalNum);
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

		//use a string builder to reverse the string (change if inefficient)
		StringBuilder sb = new StringBuilder();
		sb.append(binaryStr);
		sb = sb.reverse();
		binaryStr = sb.toString();

		return binaryStr;
	}

	//accessors and mutators
	public long getDecimalNum() {
		return decimalNum;
	}

	public void setDecimalNum(long decimalNum) {
		this.decimalNum = decimalNum;
	}
}
