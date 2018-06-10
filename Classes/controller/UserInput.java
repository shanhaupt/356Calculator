package controller;

import java.util.Arrays;

import conversions.Decimal;

public class UserInput {
	
	private UserInput_Data [] inputData = new UserInput_Data[2];
	
	//Metadata (Consistent for all input types)
		/*Note: This data is also present in UserInput_Data, but these values shoud be
		 * used as they ensure consistency across inputs 
		 */
	private boolean signed = false;
	private int inputDataSize = -1;
	
	//The following are case numbers for particular data types
		/* 5 Cases:
		 * 		Case		DataType
		 * 			
		 * 		Case 8		Char   		(1 Byte, 8 bits)
		 * 		Case 16		Short  		(2 Bytes, 16 Bits)
		 * 		Case 32		Int	   		(4 Bytes, 32 Bits) 
		 * 		Case 64	    Double 		(8 Bytes, 64 Bits)
		 * 		Case 80     Long Double (10 Bytes, 80 Bits)
		 */
	
	//The following are case strings for how the user input is represented
		/* 3 Cases:
		 * 		Case 		userInput1/2
		 * 	
		 * 		Case="bin"	Binary
		 * 		Case="dec"  Decimal
		 * 		Case="hex"	Hexadecimal
		 */
	
	//Constructor for one input
	public UserInput(String userInput1, String userInput1_representation, int inputDataType, boolean signed) {
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		this.signed = signed;
		this.inputDataSize = inputDataType;
		inputsToBinary(1);
	}
	
	//Constructor for two inputs
	public UserInput(String userInput1, String userInput1_representation, 
									String userInput2, String userInput2_representation, 
									int inputDataType, boolean signed) {
		
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		inputData[1] = new UserInput_Data(userInput2, userInput2_representation, signed);
		this.signed = signed;
		this.inputDataSize = inputDataType;
		inputsToBinary(2);
	}
	
	public void inputsToBinary(int numInputs) {
		for(int i=0; i<numInputs; i++) {
			String tempUserInput = inputData[i].getUserInput();
			
			//Input Data is of Type Char (1 Byte, 8 bits)
			if(inputDataSize == 8) {
				//User Input 1 Represented as a Binary Number
				if(inputData[i].getInputRepresentation() == "bin") {
					//function padBinaryString_to_dataType handles signed/unsigned
					tempUserInput = padBinaryString_to_dataType(tempUserInput, inputDataSize);
					inputData[i].setInputAsBinary(tempUserInput);
				}
				//User Input 1 Represented as a Decimal Number
				else if(inputData[i].getInputRepresentation() == "dec") {
					int decimalInput = Integer.parseInt(tempUserInput);
					Decimal myDecimal = new Decimal(decimalInput);	
					if(signed) {
						tempUserInput = myDecimal.signedDecimalToBinary();
					}
					else {
						tempUserInput = myDecimal.decimalToBinary();
					}
					tempUserInput = padBinaryString_to_dataType(tempUserInput, inputDataSize);
					inputData[i].setInputAsBinary(tempUserInput);
					
				}
			}
			
			
			
			//User Input 1 Represented as a Hex Number
			else if(inputData[i].getInputRepresentation() == "hex") {
					
			}
			
			
			//---TO DO---
			//Input Data is of Type Short (2 Bytes, 16 Bits)
			else if(inputDataSize==16) {
				
			}
			//---TO DO---
			//Input Data is of Type Int	(4 Bytes, 32 Bits)
			else if(inputDataSize==32) {
				
			}
			//---TO DO---
			//Input Data is of Type Double	(8 Bytes, 64 Bits)
			else if(inputDataSize==64) {
		
			}
			//---TO DO---
			//Input Data is of Type Long Double (10 Bytes, 80 Bits)
			else if(inputDataSize==80) {
		
			}
		}
	}
	
	public String padBinaryString_to_dataType(String input, int dataType) {
		
		if((input.length()<dataType+1)&&(input.length()>0)){
			char[] zeroMask = new char[dataType];
			Arrays.fill(zeroMask, '0');
			String zeroMaskString = new String(zeroMask);
			
			char[]	onesMask = new char[dataType];
			Arrays.fill(onesMask, '1');
			String onesMaskString = new String(onesMask);
			
			//check to see if binary string is 0
			int zeroChecker = Integer.parseInt(input);
			if(zeroChecker==0) {
				input = zeroMaskString;
			}
			//Binary String is not 0
			else {
				if(signed) {
					//MSB is 0
					if(input.charAt(0) == '0') {
						input = (zeroMaskString+input).substring(input.length());
					}
					//MSB is 1
					else {
						input = (onesMaskString+input).substring(input.length());
					}
				}
				else {
					//find first instance of a 1 till end of string to pad with 0's
					int firstOne = input.indexOf('1');
					//input string from first occurance of a '1' 
					input = input.substring(firstOne, input.length());
					//pad user input with 0's to fill 8 bits (i.e. char)
					input = (zeroMaskString+input).substring(input.length());
				}
			}
		}
		else {
			//TODO throw an exception here
			System.out.println("Need to throw exception here!");
		}
			
		/*
		if(signed) {
			
			if((input.length()<dataType+1)&&(input.length()>0)){
				
				
				
				//check to see if binary string is 0
				int zeroChecker = Integer.parseInt(input);
				System.out.println(zeroChecker);
				if(zeroChecker==0) {
					input = zeroMaskString;
				}
				else {
					input = (zeroMaskString+input).substring(input.length());
				}
				
			}
			//throw an exception
			else {
				//TODO throw an exception here
				System.out.println("Need to throw exception here!");
			}
			//case where user inputs 0xxxx
			//case where user inputs 1xxxx
		}
		else {
			Arrays.fill(zeroMask, '0');
			zeroMaskString = new String(zeroMask);
			//make sure user char input only contains between 1 and dataType bits
			if((input.length()<dataType+1)&&(input.length()>0)){
				//check to see if binary string is 0
				int zeroChecker = Integer.parseInt(input);
				System.out.println(zeroChecker);
				if(zeroChecker==0) {
					input = zeroMaskString;
				}
				//binary string is not zero
				else {
					//find first instance of a 1 till end of string to pad with 0's
					int firstOne = input.indexOf('1');
					//input string from first occurance of a '1' 
					input = input.substring(firstOne, input.length());
					//pad user input with 0's to fill 8 bits (i.e. char)
					input = (zeroMaskString+input).substring(input.length());
				}
			}
			//if the number does not contain between 1 and 8 bits, throw an exception!
			else {
				//TODO throw an exception here
				System.out.println("Need to throw exception here!");
			}
		}
		*/
		
		return input;
	}
	
	public String getUserInput1() {
		return inputData[0].getUserInput();
	}
	
	public String input1_toPaddedBinary() {
		return inputData[0].getInputAsBinary();
	}
	
	public void input2_toPaddedBinary() {
		
	}
	
	
}
