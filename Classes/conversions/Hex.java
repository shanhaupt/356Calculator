package conversions;

import exceptions.InvalidBinaryException;
import exceptions.InvalidHexException;

public class Hex {

	private String HexNumber;
	
	//constructors
	public Hex() {
		
	}

	public Hex(String HexNumber) {
		setHexNumber(HexNumber);
	}
	
	//convert hex to decimal
	public long hexToDecimal() throws InvalidHexException{
		long decimalValue = 0;
		int hexStrLen = HexNumber.length();
		for(int i=0; i<hexStrLen; i++) {
			try {
				long hexDecimalEquivalent = decimalEquivalent(HexNumber.charAt(i));
				decimalValue = decimalValue + (long) (hexDecimalEquivalent*(Math.pow(16, ((hexStrLen-1)-i))));
			} catch (InvalidHexException ihe){
				throw ihe;
			}
		}
		return decimalValue;
	}
	
	//convert hex to binary
	public String hexToBinary() throws InvalidHexException{
		int hexStrLen = HexNumber.length();
		Decimal hToB = new Decimal();
		String binaryRepresentation;
		
		try {
			long hexInDecimal = hexToDecimal();
			hToB.setDecimalNum(hexInDecimal);
		} catch (InvalidHexException ihe){
			throw ihe;
		}
		return hToB.decimalToBinary();
	}
	
	//convert signed hex to binary
	public String signedHexToBinary() throws InvalidHexException{
		String hex = "";
		try{
			hex += hexToBinary();
		} 
		catch (InvalidHexException e){
			e.printStackTrace();
		}
		return hex;
	}
	
	//convert signed hex to decimal
	public long signedHexToDecimal() throws InvalidBinaryException {
		String binary = "";
		try {
			binary += signedHexToBinary();
		} catch (InvalidHexException e1) {
			e1.printStackTrace();
		}
		Binary bin = new Binary(binary);
		Long decimal = 0L;
		try {
			decimal = bin.signedBinaryToDecimal();
		} catch (InvalidBinaryException e) {
			e.printStackTrace();
		}
		return decimal;
	}
	
	//Get Decimal Equivalent of Hex Number
	//Throws InvalidHexException if char is not a valid
	public int decimalEquivalent(char hex) throws InvalidHexException {
		int asciiVal = (int) hex;
		
		if (((asciiVal-'0')>=0)&&((asciiVal-'0')<=9)){
			return (asciiVal - '0');
		}
		else {
			if((asciiVal==65)||(asciiVal==97)){
				return 10;
			}
			else if((asciiVal==66)||(asciiVal==98)){
				return 11;
			}
			else if((asciiVal==67)||(asciiVal==99)){
				return 12;
			}
			else if((asciiVal==68)||(asciiVal==100)){
				return 13;
			}
			else if((asciiVal==69)||(asciiVal==101)){
				return 14;
			}
			else if((asciiVal==70)||(asciiVal==102)){
				return 15;
			}
			else {
				throw new InvalidHexException("Invalid Hex Number");
			}
		}
		
	}
	
	//getters and setters
	public void setHexNumber(String HexNumber) {
		this.HexNumber=HexNumber;
	}
	
	public String getHexNumber() {
		return HexNumber;
	}
}
