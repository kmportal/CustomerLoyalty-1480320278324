package com.ibm.cl.dao;

import java.util.ArrayList;

import com.ibm.cl.dto.ReferralDto;
import com.ibm.cl.forms.ReferralFormBean;
import com.ibm.core.exception.DAOException;

public interface ReferralDao {

	public ArrayList<ReferralDto> referUserProducts() throws DAOException;
	public String referedUserCreation(ReferralFormBean userBean)throws DAOException;
}
