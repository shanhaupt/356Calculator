
public class Decimal {

	//convert decimal to binary
	public String decimalToBinary(long decimalVal) {
		String binaryStr = "";

		/*divide the decimal value by 2, append the remainder to the binary string
		as long as the decimal value is greater than 0 */
		while(decimalVal > 0) {
			long remainder = decimalVal - ((long)Math.floor(decimalVal/2)*2);
			binaryStr += remainder;
			decimalVal = decimalVal/2;
		}

		//use a string builder to reverse the string (change if inefficient)
		StringBuilder sb = new StringBuilder();
		sb.append(binaryStr);
		sb = sb.reverse();
		binaryStr = sb.toString();

		return binaryStr;
	}
}
