package testing;

import operatons.Addition;
import operatons.AdditionReturn;

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
		Addition myAddition = new Addition();
		myAddition.setFirstNum("11101");
		myAddition.setSecondNum("1101");
		myAddition.setCaseNum(1);
		AdditionReturn myReturnValues = myAddition.addMe();
		System.out.println(myReturnValues.getBinaryReturn().getBinaryStr());
		System.out.println(myReturnValues.getHexReturn().getHexNumber());
		System.out.println(myReturnValues.getDecimalReturn().getDecimalNum());
	}
}

	
	