package com.ibm.cl.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.cl.dto.ProductDto;
import com.ibm.cl.service.UserRegistrationService;
import com.ibm.cl.service.impl.UserRegistrationServiceImpl;

public class UserProductAction extends Action {
	
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response){
		
		UserRegistrationService userService=new UserRegistrationServiceImpl();
		ArrayList<ProductDto> list=userService.fetchProducts();
		
		request.setAttribute("productList", list);
		
		
		return mapping.findForward("productSucess");

	}
}
