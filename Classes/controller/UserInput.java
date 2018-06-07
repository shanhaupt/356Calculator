package controller;

public class UserInput {
	
	UserInput_Data [] inputData = new UserInput_Data[2];
	
	//Metadata (Consistent for all input types)
		/*Note: This data is also present in UserInput_Data, but these values shoud be
		 * used as they ensure consistency across inputs 
		 */
	private boolean signed = false;
	private int inputDataType = -1;
	
	//The following are case numbers for particular data types
		/* 5 Cases:
		 * 		Case		DataType
		 * 			
		 * 		Case 1		Char   		(1 Byte, 8 bits)
		 * 		Case 2		Short  		(2 Bytes, 16 Bits)
		 * 		Case 3		Int	   		(4 Bytes, 32 Bits) 
		 * 		Case 4	    Double 		(8 Bytes, 64 Bits)
		 * 		Case 5      Long Double (10 Bytes, 80 Bits)
		 */
	
	//The following are case strings for how the user input is represented
		/* 3 Cases:
		 * 		Case 		userInput1/2
		 * 	
		 * 		Case="bin"	Binary
		 * 		Case="dec"  Decimal
		 * 		Case="hex"	Hexadecimal
		 */
	
	public void UserInput_OneInput(String userInput1, String userInput1_representation, int inputDataType, boolean signed) {
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		this.signed = signed;
		this.inputDataType = inputDataType;
		inputsToBinary(1);
	}
	
	public void UserInput_TwoInputs(String userInput1, String userInput1_representation, 
									String userInput2, String userInput2_representation, 
									int inputDataType, boolean signed) {
		
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		inputData[1] = new UserInput_Data(userInput2, userInput2_representation, signed);
		this.signed = signed;
		this.inputDataType = inputDataType;
		inputsToBinary(2);
	}
	
	public void inputsToBinary(int numInputs) {
		for(int i=0; i<numInputs; i++) {
			//Input Data is of Type Char (1 Byte, 8 bits)
			if(inputDataType == 1) {
				//User Input 1 Represented as a Binary Number
				if(inputData[i].getInputRepresentation() == "bin") {
					//Input(s) are signed number(s)
					if (signed) {
						
					}
					//Input(s) are unsigned number(s)
					else {
						
					}
				}
				//User Input 1 Represented as a Decimal Number
				else if(inputData[i].getInputRepresentation() == "dec") {
					
				}
				//User Input 1 Represented as a Hex Number
				else if(inputData[i].getInputRepresentation() == "hex") {
					
				}
			}
			
			
			//---TO DO---
			//Input Data is of Type Short (2 Bytes, 16 Bits)
			else if(inputDataType==2) {
				
			}
			//---TO DO---
			//Input Data is of Type Int	(4 Bytes, 32 Bits)
			else if(inputDataType==3) {
				
			}
			//---TO DO---
			//Input Data is of Type Double	(8 Bytes, 64 Bits)
			else if(inputDataType==4) {
		
			}
			//---TO DO---
			//Input Data is of Type Long Double (10 Bytes, 80 Bits)
			else if(inputDataType==5) {
		
			}
		}
	}
	
	public void input1_toBinary() {
		
	}
	
	public void input2_toBinary() {
		
	}
	
	
}
