package com.ibm.cl.forms;

import org.apache.struts.action.ActionForm;

public class CampaignPageForm extends ActionForm {
	
	private String message="";
	private String validFrom = "";
	private String validTo = "";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	
	public void reset()
	{
		message="";
		validFrom = "";
		validTo = "";
	}

}
