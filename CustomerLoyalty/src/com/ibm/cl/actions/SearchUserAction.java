package com.ibm.cl.actions;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.cl.service.SearchUserService;
import com.ibm.cl.service.UserRegistrationService;
import com.ibm.cl.service.impl.SearchUserServiceImpl;
import com.ibm.cl.service.impl.UserRegistrationServiceImpl;

public class SearchUserAction extends DispatchAction{
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		System.out.println("************************");
		return mapping.findForward("userSearch");
		
	}
	public ActionForward userSearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ArrayList<UserRegistrationDto> list = new ArrayList<UserRegistrationDto>();
		UserRegistrationDto dto = null;
		UserRegistrationFormBean userBean = (UserRegistrationFormBean) form;
		SearchUserService userService = new SearchUserServiceImpl();
		list = userService.searchUser(userBean);
		
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			dto = (UserRegistrationDto)iter.next();
			userBean.setFirstName(dto.getFirstName());
			userBean.setLastName(dto.getLastName());
			userBean.setMobileNumber(dto.getMobileNumber());
			userBean.setCardNumber(dto.getCardNumber());
			userBean.setPointsRewarded(dto.getPointsRewarded());
			userBean.setEmail(dto.getEmail());
			
				
		}
		return mapping.findForward("userDetails");
	
	}

}
