package com.ibm.cl.dao;

import java.util.ArrayList;

import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.core.exception.DAOException;

public interface UserRegistrationDao {

	public ArrayList<UserRegistrationDto> createUser(UserRegistrationFormBean userBean) throws DAOException;
	public String addProduct(int prodId,String mobNo) throws DAOException;
	public String validate(String mobNo) throws DAOException;
	public String userLoginAuthenticate(String user, String pass) throws DAOException;
	
	
}
