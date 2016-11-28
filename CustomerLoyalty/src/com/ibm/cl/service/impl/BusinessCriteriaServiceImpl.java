package com.ibm.cl.service.impl;

import com.ibm.cl.dao.BusinessCriteriaDao;
import com.ibm.cl.dao.impl.BusinessCriteriaDaoImpl;

import com.ibm.cl.forms.BusinessCriteriaFormBean;
import com.ibm.cl.service.BusinessCriteriaService;

public class BusinessCriteriaServiceImpl implements BusinessCriteriaService {

	public  boolean addCriteria(BusinessCriteriaFormBean businessCriteriaBean) {
		
		BusinessCriteriaDao BusinessCriteriaDao = BusinessCriteriaDaoImpl.businessCriteriaDaoInstance();
		boolean returnBusinessCriteriaDto =  BusinessCriteriaDao.addCriteria(businessCriteriaBean);
		return returnBusinessCriteriaDto;
	}

	@Override
	public BusinessCriteriaFormBean fetchCriteria(BusinessCriteriaFormBean criteriaBean) {
		// TODO Auto-generated method stub
		BusinessCriteriaDao BusinessCriteriaDao = BusinessCriteriaDaoImpl.businessCriteriaDaoInstance();
	    criteriaBean =  BusinessCriteriaDao.fetchCriteria(criteriaBean);
		return criteriaBean;
	}

}
