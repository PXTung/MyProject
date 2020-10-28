package com.bookmanagement.model;

public class Reader extends Person {
	private String redId;
	private String redType;
	private String redPhone;
	private String redEmail;
	
	public Reader() {
		super();
	}

	public Reader(Person person, String redId,
			String redType, String redPhone, String redEmail) {
		super(person.getPerId(), person.getPerName(), person.getPerAddress(), 
				person.getPerDob(), person.getPerGender());
		this.redId = redId;
		this.redType = redType;
		this.redPhone = redPhone;
		this.redEmail = redEmail;
	}

	public String getRedId() {
		return redId;
	}

	public void setRedId(String redId) {
		this.redId = redId;
	}

	public String getRedType() {
		return redType;
	}

	public void setRedType(String redType) {
		this.redType = redType;
	}

	public String getRedPhone() {
		return redPhone;
	}

	public void setRedPhone(String redPhone) {
		this.redPhone = redPhone;
	}

	public String getRedEmail() {
		return redEmail;
	}

	public void setRedEmail(String redEmail) {
		this.redEmail = redEmail;
	}

	@Override
	public String toString() {
		return "Reader [redId=" + redId + ", redType=" + redType + ", redPhone=" + redPhone + ", redEmail=" + redEmail
				+ "]" + super.toString();
	}
	
	
}
