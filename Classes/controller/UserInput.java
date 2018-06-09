package controller;

import java.util.Arrays;

public class UserInput {
	
	UserInput_Data [] inputData = new UserInput_Data[2];
	
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
			
			//Input Data is of Type Char (1 Byte, 8 bits)
			if(inputDataSize == 8) {
				char [] charBinaryString = new char[8];
				//User Input 1 Represented as a Binary Number
				if(inputData[i].getInputRepresentation() == "bin") {
					
					//Input(s) are signed number(s)
					if (signed) {
						
					}
					//Input(s) are unsigned number(s)
					else {
						String tempUserInput = inputData[i].getUserInput();
						tempUserInput = zeroPadUnsignedBinaryString(tempUserInput, inputDataSize);
						System.out.println("tempUserInput @ Line 73: "+tempUserInput);
					}
				}
			}
			
			//User Input 1 Represented as a Decimal Number
			else if(inputData[i].getInputRepresentation() == "dec") {
					
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
	
	public String zeroPadUnsignedBinaryString(String input, int dataType) {
		
		char[] zeroMask = new char[dataType];
		String zeroMaskString;
		if(signed) {
			Arrays.fill(zeroMask, '1');
			zeroMaskString = new String(zeroMask);
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
		
		
		
		
		
		
		
		return input;
	}
	
	public void input1_toBinary() {
		
	}
	
	public void input2_toBinary() {
		
	}
	
	
}
