package operatons;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;
import exceptions.InvalidBinaryException;
import exceptions.InvalidHexException;

public class Addition {
	
	//data members
	private String binaryNum1;
	private String binaryNum2;
	private String subtractionProduct;
	private boolean signed;
	
	/*9 Cases:
	 * 		Case	Num1		Num2
	 * 
	 * 		Case1:	Binary	 	Binary 
	 * 		Case2:	Hex	 		Hex
	 * 		Case3:	Decimal 	Decimal
	 * 		Case4:	Binary	 	Hex
	 * 		Case5:	Binary	 	Decial
	 * 		Case6:	Hex 		Binary
	 * 		Case7:	Hex 		Decimal
	 * 		Case8:	Decimal 	Binary
	 * 		Case9:	Decimal 	Hex
	 */
		
	
	//constructors
	public Addition() {
		
	}

	public Addition(String firstNum, String secondNum, boolean signed) {
		this.binaryNum1 = firstNum;
		this.binaryNum2 = secondNum;
		this.signed = signed;
		subtractionProduct = "0";
	}
	
	//perform addition
	public AdditionReturn addMe() {
		
		AdditionReturn myReturn = new AdditionReturn();

		//get sum from the addHelp function
		String sum = addHelp(binaryNum1, binaryNum2);
		
		//System.out.println("binaryNum1: "+binaryNum1);
		//System.out.println("binaryNum2: "+binaryNum2);
		//System.out.println("SUM@LINE 51: "+sum);
		
		//convert the binary value of the sum to decimal and hex, create an AdditionReturn object with these 
		//values and return that object
		Binary binaryVal = new Binary(sum);
		Decimal decimalVal = new Decimal();
		Hex hexVal = new Hex();		
		
		if(signed == false) {
			try {
				decimalVal = new Decimal(binaryVal.binaryToDecimal());
			} catch (InvalidBinaryException e) {
				e.printStackTrace();
			}
			try {
				hexVal = new Hex(binaryVal.binaryToHex());
			} catch (InvalidBinaryException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				decimalVal = new Decimal(binaryVal.signedBinaryToDecimal());
			} catch (InvalidBinaryException e) {
				e.printStackTrace();
			}
			hexVal = new Hex(binaryVal.signedBinaryToHex());
		}
		
		myReturn = new AdditionReturn(decimalVal, binaryVal, hexVal);
		return myReturn;		
	}
	
	//add help function
	private String addHelp(String binary1, String binary2) {
		//System.out.println("binaryNum1_HELPER: "+binary1);
		//System.out.println("binaryNum2_HELPER: "+binary2);
		//find max length of both strings
		int lenStr1 = binary1.length();
		int lenStr2 = binary2.length();
		//System.out.println("Addition Line 91 -> I1 Len: "+lenStr1);
		//System.out.println("Addition Line 92 -> I2 Len: "+lenStr2);
		//set longer strings length as totLen
		int longerLen = 0;
		int shorterLen = 0;
		if(lenStr1>lenStr2) {
			longerLen = lenStr1;
			shorterLen = lenStr2;
		}else {
			longerLen = lenStr2;
			shorterLen = lenStr1;
		}
		//sum up the two binary strings
		char carryOver='0';
		String product= "";
		binary1 = reverseString(binary1);
		binary2 = reverseString(binary2);
		for(int i=0; i<shorterLen; i++){
			//case1 1+1
			if ((binary1.charAt(i)=='1')&&(binary2.charAt(i)=='1')) {
				//no carryover
				if(carryOver=='0') {
					carryOver = '1';
					product += '0';
				}
				//carryover
				else {
					carryOver = '1';
					product += '1';
				}
			}
			
			//case2 0+0
			else if((binary1.charAt(i) == '0') && (binary2.charAt(i) == '0')) {
				//no carryover
				if(carryOver == '0') {
					product += '0';
				}
				//carryover
				else {
					product += '1';
					carryOver = '0';
				}
			}
			
			//case3 1+0 OR 0+1
			else if(((binary1.charAt(i) == '0') && (binary2.charAt(i) == '1')) || 
					((binary1.charAt(i) == '1') && (binary2.charAt(i) == '0'))) {
				//no carryover
				if(carryOver == '0') {
					product += '1';
				}
				//carryover
				else {
					product += '0';
					carryOver = '1';
				}
			}
			
		//if one binary string was longer than the other, add the remaining value
		}
		
		//if first string is longer than second string
		if(lenStr1>lenStr2) {
			int charsRemaining = lenStr1-lenStr2;
			for(int i=lenStr2; i < lenStr1; i++) {
				if(binary1.charAt(i) == '1') {
					if(carryOver == '1') {
						carryOver = '1';
						product += '0';
					}
					else {
						product += '1';
						carryOver = '0';
					}
				}
				else {
					if(carryOver == '1') {
						product += '1';
						carryOver = '0';
					}
					else {
						product += '0';
						carryOver = '0';
					}
				}
			}
		}
		
		//if second string is longer than first string
		else {
			int charsRemaining = lenStr2-lenStr1;
			for(int i=lenStr1; i < lenStr2; i++) {
				if(binary2.charAt(i) == '1') {
					if(carryOver == '1') {
						carryOver = '1';
						product += '0';
					}
					else {
						product += '1';
						carryOver = '0';
					}
				}
				else {
					if(carryOver == '1') {
						product += '1';
						carryOver = '0';
					}
					else {
						product += '0';
						carryOver = '0';
					}
				}
			}
		}
		
		subtractionProduct = reverseString(product);
		
		//add in carryover in case where carryover = 1
		if(carryOver == '1') {
			product+='1';
		}
		
		//return the binary sum
		product = reverseString(product);
		return product;
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
	public String getFirstNum() {
		return binaryNum1;
	}

	public void setFirstNum(String firstNum) {
		this.binaryNum1 = firstNum;
	}

	public String getSecondNum() {
		return binaryNum2;
	}

	public void setSecondNum(String secondNum) {
		this.binaryNum2 = secondNum;
	}
	
	public boolean getSigned() {
		return signed;
	}
	
	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	public String getSubtractionProduct() {
		return subtractionProduct;
	}

	
	
}
