package controller;

public class UserInput_Data {
	private String input;
	private String inputRepresentation;
	private int inputLength = -1;
	
	private boolean signed;
	
	private String inputAsBinary;
	
	public UserInput_Data(String input, String inputRepresentation, boolean signed) {
		this.input = input;
		this.inputRepresentation = inputRepresentation;
		this.signed = signed;
		this.inputLength = input.length();
	}
	
	
	public String getUserInput() {
		return input;
	}
	
	public String getInputRepresentation() {
		return inputRepresentation;
	}
	
	public int getInputLength() {
		return inputLength;
	}
	
	public boolean getSigned() {
		return signed;
	}
	
	public void setInputAsBinary(String inputAsBinary) {
		this.inputAsBinary = inputAsBinary;
	}
	
	public String getInputAsBinary() {
		return inputAsBinary;
	}
}
