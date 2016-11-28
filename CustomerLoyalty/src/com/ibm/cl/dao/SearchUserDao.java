package com.ibm.cl.dao;

import java.util.ArrayList;

import com.ibm.cl.dto.ProductDto;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.core.exception.DAOException;

public interface SearchUserDao {
	
	public ArrayList<UserRegistrationDto> searchUser(UserRegistrationFormBean userBean) throws DAOException;
	public ArrayList<ProductDto> fetchProducts() throws DAOException;

}
