package com.ibm.cl.forms;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.ibm.cl.dto.ReferralDto;

public class ReferralFormBean extends ActionForm {

	private ArrayList<ReferralDto> productList;
	private String productId;
	private String mobileNumber;
	private String customerName;
	private String address;
	private String circle;
	private String alternatemobileNumber;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getAlternatemobileNumber() {
		return alternatemobileNumber;
	}

	public void setAlternatemobileNumber(String alternatemobileNumber) {
		this.alternatemobileNumber = alternatemobileNumber;
	}

	public ArrayList<ReferralDto> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ReferralDto> productList) {
		this.productList = productList;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void reset()
	{
		productId="";
		mobileNumber="";
		customerName="";
		address="";
		circle="";
		alternatemobileNumber="";
	}
}
