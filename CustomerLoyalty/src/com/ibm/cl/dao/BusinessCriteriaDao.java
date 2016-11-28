package com.ibm.cl.dao;


import com.ibm.cl.forms.BusinessCriteriaFormBean;
import com.ibm.core.exception.DAOException;

public interface BusinessCriteriaDao {

	public boolean addCriteria(BusinessCriteriaFormBean userBean) throws DAOException;
	public BusinessCriteriaFormBean fetchCriteria(BusinessCriteriaFormBean userBean) throws DAOException;
}
