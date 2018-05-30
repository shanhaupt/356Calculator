package operatons;

import conversions.Binary;
import conversions.Decimal;
import conversions.Hex;

public class AdditionReturn {
	
	//data members
	private Decimal decimalReturn;
	private Binary binaryReturn;
	private Hex hexReturn;
	
	//default constructor
	public AdditionReturn() {
		
	}
	
	//constructor
	public AdditionReturn(Decimal decimalReturn, Binary binaryReturn, Hex hexReturn) {
		this.decimalReturn = decimalReturn;
		this.binaryReturn = binaryReturn;
		this.hexReturn = hexReturn;
	}


	//accessors and mutators
	public Decimal getDecimalReturn() {
		return decimalReturn;
	}

	public void setDecimalReturn(Decimal decimalReturn) {
		this.decimalReturn = decimalReturn;
	}

	public Binary getBinaryReturn() {
		return binaryReturn;
	}

	public void setBinaryReturn(Binary binaryReturn) {
		this.binaryReturn = binaryReturn;
	}

	public Hex getHexReturn() {
		return hexReturn;
	}

	public void setHexReturn(Hex hexReturn) {
		this.hexReturn = hexReturn;
	}	
	
	
}
