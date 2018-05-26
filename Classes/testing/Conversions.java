package testing;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;
import exceptions.InvalidBinaryException;
import exceptions.InvalidHexException;

public class Conversions {
	
	public static void main(String [] args) {
		
		//basic testing to make sure everything is working normally
		
		/*
		Hex hToDTesting = new Hex("abcd");
		System.out.println(hToDTesting.getHexNumber());
		hToDTesting.setHexNumber("aaaa");
		System.out.println(hToDTesting.getHexNumber());
		*/
		
		
		
		//testing of hex decimal Equivalent
		
		/*
		hToDTesting.setHexNumber("af15f7d");
		
		System.out.println(hToDTesting.getHexNumber());
		try{
			System.out.println(hToDTesting.HexToDecimal());
			System.out.println(hToDTesting.HexToBinary());
		} catch (InvalidHexException ihe) {
			ihe.printStackTrace();
		}
		*/
		
		//testing of decimal to hex
		
		/*
		Decimal decimalTesting = new Decimal();
		decimalTesting.setDecimalNum(122352234522345L);
		System.out.println(decimalTesting.decimalToHex());
		*/
		
		//testing of binary to hex
		
		
		Binary binaryTesting = new Binary();
		binaryTesting.setBinaryStr("11111101");
		try {
			System.out.println(binaryTesting.binaryToHex());
		} catch (InvalidBinaryException e) {
			e.printStackTrace();
		}
		
				
	}
}
