package com.ibm.cl.forms;

import org.apache.struts.action.ActionForm;

public class BusinessCriteriaFormBean extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productVal ="";
	private String points = "";
	private String pointsNew = "";
	private int usageAmount;
	

	
	public String getPointsNew() {
		return pointsNew;
	}
	public void setPointsNew(String pointsNew) {
		this.pointsNew = pointsNew;
	}
	public String getProductVal() {
		return productVal;
	}
	public void setProductVal(String productVal) {
		this.productVal = productVal;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public int getUsageAmount() {
		return usageAmount;
	}
	public void setUsageAmount(int usageAmount) {
		this.usageAmount = usageAmount;
	}
	
	
	
}
