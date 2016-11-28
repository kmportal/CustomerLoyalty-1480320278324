package com.ibm.cl.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ibm.cl.dto.CampaignDetailsDto;
import com.ibm.cl.forms.CampaignPageForm;
import com.ibm.cl.service.CampaignPageService;
import com.ibm.cl.service.impl.CampaignPageServiceImpl;

public class CampaignPageAction  extends DispatchAction{

	public ActionForward forwardCampaignPage(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		ActionForward forward = null;
		ArrayList<CampaignDetailsDto> campaignDetails = null;
		CampaignPageForm campaignForm = (CampaignPageForm)form;
		try{
		//System.out.println("here");
		CampaignPageService campaignService = new CampaignPageServiceImpl();
		campaignDetails = campaignService.getCampaignDetails();
		request.setAttribute("CAMPAIGN_DETAILS", campaignDetails);
		forward =  mapping.findForward("campaignDetailsPage");
		//System.out.println("endddddd");
		//System.out.println("campaign size"+campaignDetails.size());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return forward;
	}
}
