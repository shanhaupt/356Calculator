package modelTesting;

import org.junit.Test;
import org.junit.runner.RunWith;

import exceptions.AlreadySetUserInputAsBinary;
import exceptions.UnsupportedDataTypeException;
import org.junit.Assert;
import model.UserInput;
import model.UserInput_Data;


@RunWith(RunAllModelTests.class)
public class UserInput_Testing {
	
//	//Constructor for one input
//		UserInput(String userInput1, String userInput1_representation, 
// 			  	  int inputDataType, boolean signed
//	
//	
//	//Constructor for two inputs
//		UserInput(String userInput1, String userInput1_representation, 
//				  String userInput2, String userInput2_representation, 
//				  int inputDataType, boolean signed)
//
// Both Throw: AlreadySetUserInputAsBinary, UnsupportedDataTypeExcaption 
	
	@Test
	public void unsignedChar_HexToBinary_Testing1() {
		String userInput1 = "a";
		String userInput1_representation = "hex";
		int inputDataType = 8;
		boolean signed = false;
		
		String result = unsignedChar_HexToDecimal_Testing1_MASTER(userInput1, userInput1_representation, inputDataType, signed);
		
		String result_expected = "00001010";
		Assert.assertEquals(result_expected, result);
	}
	
	@Test
	public void unsignedChar_HexToBinary_Testing2() {
		String userInput1 = "ff";
		String userInput1_representation = "hex";
		int inputDataType = 8;
		boolean signed = false;
		
		String result = unsignedChar_HexToDecimal_Testing1_MASTER(userInput1, userInput1_representation, inputDataType, signed);
		
		String result_expected = "11111111";
		Assert.assertEquals(result_expected, result);
	}
	
	@Test
	public void unsignedChar_HexToBinary_Testing3() {
		String userInput1 = "00";
		String userInput1_representation = "hex";
		int inputDataType = 8;
		boolean signed = false;
		
		String result = unsignedChar_HexToDecimal_Testing1_MASTER(userInput1, userInput1_representation, inputDataType, signed);
		
		String result_expected = "00000000";
		Assert.assertEquals(result_expected, result);
	}
	
	
	public String unsignedChar_HexToDecimal_Testing1_MASTER(String userInput, String inputRepresentation,
															int inputDataType, boolean signed) {
		UserInput tester1 = null;
		try {
			tester1 = new UserInput(userInput, inputRepresentation, inputDataType, signed);
		} catch(AlreadySetUserInputAsBinary | UnsupportedDataTypeException e){
			e.printStackTrace();
		}
		return tester1.get_Input1_toPaddedBinary();
	}
	
}
