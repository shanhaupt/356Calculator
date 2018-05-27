package testing;

import java.util.Scanner;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;
import exceptions.InvalidBinaryException;
import exceptions.InvalidHexException;

public class Conversions {
	
	public static void main(String [] args) {
		
		int menuChoice = -1;
		System.out.println("---356 Calculator---");
		while (menuChoice != 3) {
			System.out.println("Please select an option from the following menu:");
			System.out.println("	1) Binary, Hex, Decimal Conversions");
			System.out.println("	2) Run Binary, Hex, Decimal Conversions Test Cases");
			System.out.println("	3) Exit 356 Calculator");
			Scanner myScanner = new Scanner(System.in);
			menuChoice = myScanner.nextInt();
			//Main menu choice for binary, hex and decimal conversions
			if(menuChoice == 1) {
				int conversionType = 0;
				while(conversionType == 0) {
					System.out.println("\nWhat type of number are you entering:");
					System.out.println("	1) Binary");
					System.out.println("	2) Hexadecimal");
					System.out.println("	3) Decimal");
					conversionType = myScanner.nextInt();
					if (conversionType == 1) {
						Binary myBinary = new Binary();
						System.out.println("\nPlease enter the Binary number you would like to convert: ");
						String binStr = myScanner.next();
						myBinary.setBinaryStr(binStr);
						try {
							System.out.println("   Hexadecimal: "+myBinary.binaryToHex());
							System.out.println("   Decimal:     "+myBinary.binaryToDecimal());
						} catch (InvalidBinaryException e) {
							System.out.println("Please enter a valid binary string...\n");
							//e.printStackTrace();
						}
					}
					else if(conversionType == 2) {
						Hex myHex = new Hex();
						System.out.println("\nPlease enter the Hexadecimal number you would like to convert: ");
						String hexStr = myScanner.next();
						myHex.setHexNumber(hexStr);
						try {
							System.out.println("   Binary:  "+myHex.hexToBinary());
							System.out.println("   Decimal: "+myHex.hexToDecimal());
						} catch (InvalidHexException e) {
							System.out.println("Please enter a vaild hex string...\n");
							//e.printStackTrace();
						}
					}
					else if(conversionType==3) {
						Decimal myDecimal = new Decimal();
						System.out.println("\nPlease enter the Decimal number you would like to convert: ");
						Long decStr = myScanner.nextLong();
						myDecimal.setDecimalNum(decStr);
						System.out.println("   Binary: "+myDecimal.decimalToBinary());
						System.out.println("   Hex:    "+myDecimal.decimalToHex());
					}
					else {
						System.out.println("Please enter a valid menu choice...\n");
						conversionType = 0;
					}
				}
			}
			//Main Menu Choice to exit the program
			else if(menuChoice == 3) {
				System.out.println("Thank you for using Sonali Pai and Shan Haupt's CSCI356 Calculator!");
				myScanner.close();
			}
			else {
				System.out.println("Please enter a valid menu choice...\n");
				menuChoice = -1;
			}
		}
		
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
		
		/*
		Binary binaryTesting = new Binary();
		binaryTesting.setBinaryStr("11111101");
		try {
			System.out.println(binaryTesting.binaryToHex());
		} catch (InvalidBinaryException e) {
			e.printStackTrace();
		}
		*/
				
	}
}
