package operatons;

import exceptions.InvalidBinaryException;

public class Subtraction {
	//data members
	private String firstNum;
	private String secondNum;
	private boolean signed;
	private Addition add;
	
	//constructors
	public Subtraction() {
		
	}

	public Subtraction(String firstNum, String secondNum, boolean signed) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.signed = signed;
	}
	
	//subtraction method (perform two's complement on the subtrahend)
	public String subtractMe() throws InvalidBinaryException {
		//unsigned subtraction
		if(!signed) {
			try {
				int n = Integer.parseInt(firstNum, 2);
				int n2 = Integer.parseInt(secondNum, 2);
				StringBuilder modifiedResult = new StringBuilder(secondNum);
				
				//two's complement the subtrahend
				for(int i = 0; i < secondNum.length(); i++) {
					if(secondNum.charAt(i) == '0') {
						modifiedResult.setCharAt(i, '1');
					}
					else if(secondNum.charAt(i) == '1') {
						modifiedResult.setCharAt(i, '0');
					}
				}
				secondNum = modifiedResult.toString();
				
				//add 1 to the flipped string
				Addition add = new Addition(secondNum, "1", true);
				AdditionReturn ar = add.addMe();
				secondNum = ar.getBinaryReturn().getBinaryStr();
				System.out.println("Second Number 2's Compliment: "+secondNum);
				
				//add the firstNum and the two's complement of secondNum
				add = new Addition(firstNum, secondNum, signed);
				add.addMe();
				return add.getSubtractionProduct();	
			}
			catch(NumberFormatException nfe) {
				throw new InvalidBinaryException("Invalid binary number");
			}
		}
		//if signed
		else {
			return null;
		}
	}
	
	
	
	//accessors and mutators
		public String getFirstNum() {
			return firstNum;
		}

		public void setFirstNum(String firstNum) {
			this.firstNum = firstNum;
		}

		public String getSecondNum() {
			return secondNum;
		}

		public void setSecondNum(String secondNum) {
			this.secondNum = secondNum;
		}

		public boolean isSigned() {
			return signed;
		}

		public void setSigned(boolean signed) {
			this.signed = signed;
		}
		
		
}
