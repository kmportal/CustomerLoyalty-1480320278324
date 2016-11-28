package com.ibm.cl.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.ibm.cl.dto.ReferralDto;
import com.ibm.cl.forms.ReferralFormBean;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.cl.service.ReferralService;
import com.ibm.cl.service.impl.ReferralServiceImpl;

public class ReferralAction extends DispatchAction {
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		System.out.println("***********init*************");
		  saveToken(request);
		ReferralFormBean userBean = new ReferralFormBean();
		ReferralService refservice=new ReferralServiceImpl();
		ArrayList<ReferralDto> productList=refservice.referUserProducts();
		request.setAttribute("listOfProducts", productList);
		
		return mapping.findForward("referPage");
		
	}
	
	public ActionForward referedUserCreation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		System.out.println("*********referedUserCreation***************");
		//System.out.println( "======="+);
		if(!isTokenValid(request)) {
			return	mapping.findForward("referPage");
		}
		String insertStatus="";
		ReferralFormBean userBean = (ReferralFormBean) form;
		System.out.println("============================================================"+userBean.getProductId());
		ReferralService refservice=new ReferralServiceImpl();
		insertStatus=refservice.referedUserCreation(userBean);
		
		request.setAttribute("leadCreateStatus", insertStatus);
		form.reset(mapping, request);
		resetToken(request);
		return mapping.findForward("referdone");
		
	}


}
