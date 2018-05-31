package operatons;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;
import exceptions.InvalidHexException;

public class InputCases {
	
	private String firstNum;
	private String secondNum;
	private String binaryNum1 = "";
	private String binaryNum2 = "";
	private int caseNum;
	private boolean signed;
	
	//Constructors
	public InputCases(String firstNum, String secondNum, int caseNum, boolean signed) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.caseNum = caseNum;
		this.signed = signed;
		inputStringToBinaryString();
	}
	
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
	
	public void inputStringToBinaryString() {
		Binary myBinary = new Binary();
		Hex myHex = new Hex();
		Hex myHex2 = new Hex();
		Decimal myDecimal = new Decimal();
		Decimal myDecimal2 = new Decimal();
		
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
	}
	
	private long stringToLong(String num) {
		long myNum = new Long(num);
		return myNum;
	}
	
	//getters
	
	public String getBinaryString1() {
		return binaryNum1;
	}
	
	public String getBinaryString2() {
		return binaryNum2;
	}
	
}
