package operatons;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;
import exceptions.InvalidBinaryException;
import exceptions.InvalidHexException;

public class Addition {
	
	//data members
	private String firstNum;
	private String secondNum;
	private int caseNum;
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

	public Addition(String firstNum, String secondNum, int caseNum, boolean signed) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.caseNum = caseNum;
		this.signed = signed;
	}
	
	//perform addition
	public AdditionReturn addMe() {

		String binaryNum1 = "";
		String binaryNum2 = "";
		Binary myBinary = new Binary();
		Hex myHex = new Hex();
		Hex myHex2 = new Hex();
		Decimal myDecimal = new Decimal();
		Decimal myDecimal2 = new Decimal();
		AdditionReturn myReturn = new AdditionReturn();
		
		//Case1:	Binary	 	Binary 
		if (caseNum == 1) {
			binaryNum1 = firstNum;
			binaryNum2 = secondNum;		
		}
		
		//Case2:	Hex	 		Hex
		else if(caseNum == 2) {
			//unsigned addition
			if(signed == false) {
				myHex = new Hex(firstNum);
				try {
					binaryNum1 += myHex.hexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
				myHex2 = new Hex(secondNum);
				try {
					binaryNum2 += myHex2.hexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
			}
			//signed addition
			else {
				myHex = new Hex(firstNum);
				try {
					binaryNum1 += myHex.signedHexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
				myHex2 = new Hex(secondNum);
				try {
					binaryNum2 += myHex2.signedHexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
			}
			
		}
		//Case3:	Decimal 	Decimal
		else if(caseNum == 3) {
			myDecimal = new Decimal(stringToLong(firstNum));
			myDecimal2 = new Decimal(stringToLong(secondNum));
			//unsigned addition
			if(signed == false) {
				binaryNum1 += myDecimal.decimalToBinary();
				binaryNum2 += myDecimal2.decimalToBinary();
			}
			//signed addition
			else {
				binaryNum1 += myDecimal.signedDecimalToBinary();
				binaryNum2 += myDecimal2.signedDecimalToBinary();
			}
		}
		//Case4:	Binary	 	Hex
		else if(caseNum == 4) {
			binaryNum1 += firstNum;
			//unsigned addition
			if(signed == false) {
				myHex = new Hex(secondNum);
				try {
					binaryNum2 += myHex.hexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
			}
			//signed addition
			else {
				myHex = new Hex(secondNum);
				try {
					binaryNum2 += myHex.signedHexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
			}
		
		}
		//Case5:	Binary	 	Decimal
		else if(caseNum == 5) {
			binaryNum1 += firstNum;
			myDecimal = new Decimal(stringToLong(secondNum));
			//unsigned addition
			if(signed == false) {
				binaryNum2 += myDecimal.decimalToBinary();
			}
			//signed addition
			else {
				binaryNum2 += myDecimal.signedDecimalToBinary();
			}
	
		}
		//Case6:	Hex 		Binary
		else if(caseNum == 6) {
			binaryNum2 += secondNum;
			//unsigned addition
			if(signed == false) {
				myHex = new Hex(firstNum);
				try {
					binaryNum1 += myHex.hexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
			}
			//signed addition
			else {
				myHex = new Hex(firstNum);
				try {
					binaryNum1 += myHex.signedHexToBinary();
				} catch (InvalidHexException e1) {
					e1.printStackTrace();
				}
			}
	
		}
		//Case7:	Hex 		Decimal
		else if(caseNum == 7) {
			myHex.setHexNumber(firstNum);
			myDecimal.setDecimalNum(stringToLong(secondNum));
			//unsigned addition
			if(signed==false) {
				try {
					binaryNum1 += myHex.hexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
				binaryNum2 += myDecimal.decimalToBinary();
			}
			//signed addition
			else {
				try {
					binaryNum1 += myHex.signedHexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
				binaryNum2 += myDecimal.signedDecimalToBinary();
			}
	
		}
		//Case8:	Decimal 	Binary
		else if(caseNum == 8) {
			binaryNum2 += secondNum;
			myDecimal.setDecimalNum(stringToLong(firstNum));
			//unsigned addition
			if(signed == false) {
				binaryNum1 += myDecimal.decimalToBinary();
			}
			//signed addition
			else {
				binaryNum1 += myDecimal.signedDecimalToBinary();
			}
		}
		//Case9:	Decimal 	Hex
		else if (caseNum == 9) {
			myDecimal.setDecimalNum(stringToLong(firstNum));
			myHex.setHexNumber(secondNum);
			//unsigned addition
			if(signed == false) {
				binaryNum1 += myDecimal.decimalToBinary();
				try {
					binaryNum2 += myHex.hexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
			}
			//signed addition
			else {
				binaryNum1 += myDecimal.signedDecimalToBinary();
				try {
					binaryNum2 += myHex.signedHexToBinary();
				} catch (InvalidHexException e) {
					e.printStackTrace();
				}
			}
		}
			
		//get sum from the addHelp function
		String sum = addHelp(binaryNum1, binaryNum2);
		System.out.println("binaryNum1: "+binaryNum1);
		System.out.println("binaryNum2: "+binaryNum2);
		System.out.println("SUM@LINE 228: "+sum);
		
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
		System.out.println("binaryNum1_HELPER: "+binary1);
		System.out.println("binaryNum2_HELPER: "+binary2);
		//find max length of both strings
		int lenStr1 = binary1.length();
		int lenStr2 = binary2.length();
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
		for(int i=shorterLen-1; i>=0; i--){
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
			for(int i=charsRemaining-1; i>=0; i--) {
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
			for(int i=charsRemaining-1; i>=0; i--) {
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
		
		//reverse the binary sum and return it
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
	
	private long stringToLong(String num) {
		long myNum = new Long(num);
		return myNum;
	}
	
	//accessors and mutators
	public String getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}

	public String getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}

	public int getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}
	
	
}
