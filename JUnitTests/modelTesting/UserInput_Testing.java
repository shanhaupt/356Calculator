package modelTesting;

import org.junit.Test;
import org.junit.runner.RunWith;

import exceptions.AlreadySetUserInputAsBinary;
import exceptions.UnsupportedDataTypeExcaption;
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
	public void unsignedHexToDecimalTesting_1() {
		String userInput1 = "a";
		String userInput1_representation = "hex";
		int inputDataType = 8;
		boolean signed = false;
		
		UserInput tester1 = null;
		
		try {
			tester1 = new UserInput(userInput1, userInput1_representation, inputDataType, signed);
		} catch(AlreadySetUserInputAsBinary | UnsupportedDataTypeExcaption e){
			e.printStackTrace();
		}
		
		String result = "00001010";
		Assert.assertEquals(result, tester1.get_Input1_toPaddedBinary());
		
	}
	
}
