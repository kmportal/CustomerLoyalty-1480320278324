package com.ibm.cl.actions;


import java.util.ArrayList;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ibm.cl.dao.impl.UserRegistrationDaoImpl;
import com.ibm.cl.dto.ProductDto;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.cl.service.UserRegistrationService;
import com.ibm.cl.service.impl.UserRegistrationServiceImpl;


public class UserRegistrationAction extends DispatchAction{
	
	public ActionForward initMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		System.out.println("************************");
		return mapping.findForward("userMenu");
		
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		System.out.println("************************");
		return mapping.findForward("userRegistration");
		
	}
	public ActionForward userCreation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		UserRegistrationFormBean userBean = (UserRegistrationFormBean) form;
		UserRegistrationService service = new UserRegistrationServiceImpl();
		UserRegistrationDto userDTO ;
		ArrayList<UserRegistrationDto> returnUserRegistrationDto = new ArrayList<UserRegistrationDto>();
		returnUserRegistrationDto=service.createUser(userBean);
		java.util.Iterator iter = returnUserRegistrationDto.iterator();
		
		while(iter.hasNext()){
			userDTO =(UserRegistrationDto)iter.next();
			userBean.setCardNumber(userDTO.getCardNumber());
			userBean.setMessage(userDTO.getMessage());
		

		}
		
		
		System.out.println("nbjxjdsxds");
		return mapping.findForward("registrationSuccessful");
	}
	
	public ActionForward addProduct(ActionMapping mapping, ActionForm form,
									HttpServletRequest request,HttpServletResponse response){
		
		
		UserRegistrationFormBean formBean=(UserRegistrationFormBean) form;
		Long mobNo;
		Integer prodId=0;
		mobNo=formBean.getMobileNumber();
		
		if(formBean.getProduct()!=null && !formBean.getProduct().trim().equals("") && formBean.getProduct().matches("\\d")){
			prodId=Integer.parseInt(formBean.getProduct());
			
		}
		UserRegistrationService userRegistrationService=new UserRegistrationServiceImpl();
		ArrayList<ProductDto>productList=userRegistrationService.fetchProducts();
		String validateMessage=UserRegistrationDaoImpl.userRegistrationDaoInstance().validate(mobNo.toString());
		if(validateMessage!=null && !validateMessage.trim().equals("")){
			request.setAttribute("productList", productList);
			request.setAttribute("message", validateMessage);
			return mapping.findForward("productAdded");
		}
		
		String message=userRegistrationService.addProduct(prodId, mobNo.toString());
		request.setAttribute("productList", productList);
		request.setAttribute("message", message);
		formBean.setMobileNumber(0);
		formBean.setProduct("-1");
		return mapping.findForward("productAdded");
	}
	
	 
	 public ActionForward logout(ActionMapping mapping,
	   ActionForm form,
	   HttpServletRequest request,
	   HttpServletResponse response){
	  
	  request.getSession().invalidate();
	 
	  return mapping.findForward("logout");
	  
	 }

}