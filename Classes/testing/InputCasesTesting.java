package testing;

import model.DataRepresentationInputCases;

public class InputCasesTesting {
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
		
		String input1 = "10";
		String input2 = "AF";
		int caseNum = 9;
		boolean signed = false;
		DataRepresentationInputCases myInputCases = new DataRepresentationInputCases(input1, input2, caseNum, signed);
		System.out.println("Input1 As Binary: "+myInputCases.getBinaryString1());
		System.out.println("Input2 As Binary: "+myInputCases.getBinaryString2());
		
	}
}
