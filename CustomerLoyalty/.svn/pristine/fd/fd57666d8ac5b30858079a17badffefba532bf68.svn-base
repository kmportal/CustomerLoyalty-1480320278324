package com.ibm.cl.actions;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ibm.cl.forms.BusinessCriteriaFormBean;
import com.ibm.cl.service.BusinessCriteriaService;
import com.ibm.cl.service.impl.BusinessCriteriaServiceImpl;

public class BusinessCriteriaAction extends DispatchAction {

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("**********init**************");
		return mapping.findForward("businessCriteria");

	}

	public ActionForward fetch(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("***********getProductValue************");

		BusinessCriteriaFormBean businessCriteria = (BusinessCriteriaFormBean) form;
		System.out.println("***********getProductValue************" + businessCriteria.getProductVal());
	

				BusinessCriteriaService service = new BusinessCriteriaServiceImpl();

		businessCriteria = service.fetchCriteria(businessCriteria);

		if (businessCriteria.getProductVal().equals("1")) {
			businessCriteria.setPointsNew("1");
			System.out.println("***********getProductValue************1");
		} else if (businessCriteria.getProductVal().equals("2")){
			businessCriteria.setPointsNew("2");
		}else if (businessCriteria.getProductVal().equals("3")){
			businessCriteria.setPointsNew("3");
			System.out.println("***********getProductValue************3");
		}
		else if (businessCriteria.getProductVal().equals("4")){
			businessCriteria.setPointsNew("4");
			System.out.println("***********getProductValue************4");
		}
		return mapping.findForward("businessCriteria");

	}

	public ActionForward addCriteria(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BusinessCriteriaFormBean criteriaBean = (BusinessCriteriaFormBean) form;
		BusinessCriteriaService service = new BusinessCriteriaServiceImpl();

		boolean flag = service.addCriteria(criteriaBean);

			return mapping.findForward("businessCriteria");
	
	}

}
