package testing;

import conversions.Decimal;

public class Conversions_Decimal {
	public static void main(String [] args) {
	
	long input = -10L;	
	
	Decimal myDecimal = new Decimal();
	myDecimal.setDecimalNum(input);
	String output = myDecimal.signedDecimalToBinary();
	System.out.println("The Output is: "+output);
	}
}
