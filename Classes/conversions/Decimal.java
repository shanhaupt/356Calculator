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
		String result = "";
		//if the decimal value inputed is positive
		System.out.println("signedDecimalToBinary is convewrting: "+decimalNum);
		if(decimalNum >= 0) {
			return this.decimalToBinary();
		}
		
		//if the decimal value inputed is negative
		else{
			decimalNum = Math.abs(decimalNum);
			System.out.println("AbsVal Decimal Number is: "+decimalNum);
			result = this.decimalToBinary();
			System.out.println("AbsVal Decimal Number to Binary: "+result);
			StringBuilder modifiedResult = new StringBuilder(result);
			
			//two's complement
			for(int i = 0; i < result.length(); i++) {
				if(result.charAt(i) == '0') {
					modifiedResult.setCharAt(i, '1');
				}
				else if(result.charAt(i) == '1') {
					modifiedResult.setCharAt(i, '0');
				}
			}
			result = modifiedResult.toString();
			System.out.println("Make 1's 0's and 0's 1's: "+result);
			
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
			
			//reverse the string as it was built in reverse order
			signedBinary = reverseString(signedBinary);
			
			//if decimalNum was initially negative, set it back to negative
			decimalNum = decimalNum*-1;
			
			return signedBinary;
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
