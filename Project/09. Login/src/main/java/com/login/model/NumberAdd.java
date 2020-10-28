package com.login.model;

public class NumberAdd {
	private String number1;
	private String number2;
	private String sum;
	
	public NumberAdd() {
		super();
	}	

	public NumberAdd(String number1, String number2, String sum) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.sum = sum;
	}

	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

}
