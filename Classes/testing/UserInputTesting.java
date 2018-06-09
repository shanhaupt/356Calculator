package testing;

import controller.UserInput;

public class UserInputTesting {
	public static void main(String [] args) {
		
		
		String inputString1 = "000000000";
		String inputString1_representation = "bin";
		int inputString1_dataType = 8;
		boolean signed = false;
		//
		UserInput myUserInput = new UserInput(inputString1, inputString1_representation,
												inputString1_dataType, signed);
		
	}
}
