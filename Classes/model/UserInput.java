package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import conversions.Decimal;
import conversions.Hex;
import exceptions.AlreadySetUserInputAsBinary;
import exceptions.InvalidHexException;
import exceptions.UnsupportedDataTypeExcaption;

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
	public UserInput(String userInput1, String userInput1_representation, int inputDataType, boolean signed) throws AlreadySetUserInputAsBinary, UnsupportedDataTypeExcaption {
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		this.signed = signed;
		this.inputDataSize = inputDataType;
		inputsToBinary(1);
	}
	
	//Constructor for two inputs
	public UserInput(String userInput1, String userInput1_representation, 
									String userInput2, String userInput2_representation, 
									int inputDataType, boolean signed) throws AlreadySetUserInputAsBinary, UnsupportedDataTypeExcaption {
		
		inputData[0] = new UserInput_Data(userInput1, userInput1_representation, signed);
		inputData[1] = new UserInput_Data(userInput2, userInput2_representation, signed);
		this.signed = signed;
		this.inputDataSize = inputDataType;
		inputsToBinary(2);
	}
	
	/*TODO
	 * For each inputDataSize case, we need to add the following checks:
	 * 		Prior to converting the decimal to binary (signed AND unsigned), that the number 
	 * 			Inputed can actually be represented with the number of bits specified
	 * 
	 * 		Throw an exception for padBinaryString_to_dataType()
	 */
	public void inputsToBinary(int numInputs) throws AlreadySetUserInputAsBinary, UnsupportedDataTypeExcaption {
		inputDataSizeChecker(inputDataSize);
		for(int i=0; i<numInputs; i++) {
			String tempUserInput = inputData[i].getUserInput();
			
			//User Input 1 Represented as a Binary Number
			//Dont need to do any additional processing
			
			//User Input 1 Represented as a Decimal Number
			if(inputData[i].getInputRepresentation() == "dec") {
				int decimalInput = Integer.parseInt(tempUserInput);
				Decimal myDecimal = new Decimal(decimalInput);
				
				
				if(signed) {
					tempUserInput = myDecimal.signedDecimalToBinary();
				}
				else {
					tempUserInput = myDecimal.decimalToBinary();
				}
			}
			//User Input 1 Represented as a Hex Number
			else if(inputData[i].getInputRepresentation() == "hex") {
					Hex myHex = new Hex(tempUserInput);
					if(signed) {
						try {
							tempUserInput = myHex.signedHexToBinary();
						} catch (InvalidHexException e) {
							e.printStackTrace();
						}
					}
					else {
						try {
							tempUserInput = myHex.hexToBinary();
						} catch (InvalidHexException e) {
							e.printStackTrace();
						}
					}
			}
			//add padding to ensure binary string matches num bits in data type
			tempUserInput = padBinaryString_to_dataType(tempUserInput, inputDataSize);
			//set the corresponsing input object's inputAsBinary member variable
			inputData[i].setInputAsBinary(tempUserInput);
		}
	}
	
	public String padBinaryString_to_dataType(String input, int dataType) throws UnsupportedDataTypeExcaption {
		inputDataSizeChecker(dataType);
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
		
		return input;
	}
	/* 5 Cases:
	 * 		Case		DataType
	 * 			
	 * 		Case 8		Char   		(1 Byte, 8 bits)
	 * 		Case 16		Short  		(2 Bytes, 16 Bits)
	 * 		Case 32		Int	   		(4 Bytes, 32 Bits) 
	 * 		Case 64	    Double 		(8 Bytes, 64 Bits)
	 * 		Case 80     Long Double (10 Bytes, 80 Bits)
	 */
	//Checks to see if data type is supported by the program
	public void inputDataSizeChecker(int inputDataSize) throws UnsupportedDataTypeExcaption {
		HashMap<Integer, String> supportedDataTypes = new HashMap<>();
		supportedDataTypes.put(8, "char");
		supportedDataTypes.put(16, "short");
		supportedDataTypes.put(32, "int");
		supportedDataTypes.put(64, "double");
		supportedDataTypes.put(80, "longdouble");
		if (!(supportedDataTypes.containsKey(inputDataSize))) {
			throw new UnsupportedDataTypeExcaption("Sorry, we do not support any data type of "+inputDataSize+" bits.");
		}
	}
	
	public String getUserInput1() {
		return inputData[0].getUserInput();
	}
	
	public String get_Input1_toPaddedBinary() {
		return inputData[0].getInputAsBinary();
	}
	
	public void input2_toPaddedBinary() {
		
	}
	
	
}
