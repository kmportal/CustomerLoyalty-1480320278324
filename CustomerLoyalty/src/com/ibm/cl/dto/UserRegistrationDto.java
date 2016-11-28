package com.ibm.cl.dto;

public class UserRegistrationDto {
	
	private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";
	private long mobileNumber;
	private String product ="";
	private String state = "";
	private int pincode;
	private String email = "";
	private String cardNumber = "";
	private String message = "";
	private int pointsRewarded;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public void setPointsRewarded(int pointsRewarded) {
		this.pointsRewarded = pointsRewarded;
	}
	public int getPointsRewarded() {
		return pointsRewarded;
	}


}
