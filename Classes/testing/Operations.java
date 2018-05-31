package testing;

import exceptions.InvalidBinaryException;
import operatons.Addition;
import operatons.AdditionReturn;
import operatons.Subtraction;

public class Operations {
	public static void main(String [] args) {
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
		Addition myAddition = new Addition("110101111101", "1110111111", false);
		
		AdditionReturn myReturnValues = myAddition.addMe();
		System.out.println(myReturnValues.getBinaryReturn().getBinaryStr());
		System.out.println(myReturnValues.getHexReturn().getHexNumber());
		System.out.println(myReturnValues.getDecimalReturn().getDecimalNum());
		
		Subtraction mySubtractions = new Subtraction("11011", "0011", false);
		String returnVals = null;
		try {
			returnVals = mySubtractions.subtractMe();
		} catch (InvalidBinaryException e) {
			e.printStackTrace();
		}
		System.out.println(returnVals);
		
	}
}

	
	