package testing;

import controller.UserInput;
import conversions.Binary;
import exceptions.InvalidBinaryException;

public class UserInputTesting {
	public static void main(String [] args) {
		
		System.out.println("---INPUT STRING ONE---");
		String inputString1 = "1001";
		String inputString1_representation = "bin";
		int inputString1_dataType = 8;
		boolean inputString1_signed = true;
		
		UserInput myUserInput1 = new UserInput(inputString1, inputString1_representation,
				inputString1_dataType, inputString1_signed);
		
		System.out.println("Original Input: " + myUserInput1.getUserInput1());
		System.out.println("  Padded Input: "+myUserInput1.input1_toPaddedBinary());
		
		
		Binary inputString1_original = new Binary(myUserInput1.getUserInput1());
		Binary inputString1_padding = new Binary(myUserInput1.input1_toPaddedBinary());
		try {
			if (inputString1_signed == true) {
				System.out.println("Original as Decimal (Signed): "+inputString1_original.signedBinaryToDecimal());
				System.out.println("  Padded as Decimal (Signed): "+inputString1_padding.signedBinaryToDecimal());
			}else {
				System.out.println("Original as Decimal (Unsigned): "+inputString1_original.binaryToDecimal());
				System.out.println("  Padded as Decimal (Unsigned): "+inputString1_padding.binaryToDecimal());
			}
		} catch (InvalidBinaryException ibe) {
			ibe.printStackTrace();
		}
		System.out.println("---END INPUT STRING ONE---\n\n");
		
		
		System.out.println("---INPUT STRING TWO---");
		String inputString2 = "-8";
		String inputString2_representation = "dec";
		int inputString2_dataType = 8;
		boolean inputString2_signed = true;
		
		UserInput myUserInput2 = new UserInput(inputString2, inputString2_representation,
				inputString2_dataType, inputString2_signed);
		
		System.out.println("Original Input: " + myUserInput2.getUserInput1());
		System.out.println("  Padded Input: "+myUserInput2.input1_toPaddedBinary());
		
		
		
		
		
		
		
		
		
	}
}
