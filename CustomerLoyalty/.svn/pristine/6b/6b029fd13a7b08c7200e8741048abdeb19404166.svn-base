package com.ibm.cl.service.impl;

import java.util.ArrayList;

import com.ibm.cl.dao.SearchUserDao;
import com.ibm.cl.dao.impl.SearchUserDaoImpl;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.cl.service.SearchUserService;
import java.util.Iterator;

public class SearchUserServiceImpl implements SearchUserService  {

	public ArrayList<UserRegistrationDto> searchUser(
			UserRegistrationFormBean userBean) {
	
		ArrayList<UserRegistrationDto> list = new ArrayList<UserRegistrationDto>();
		UserRegistrationDto dto = null;
		SearchUserDao dao = SearchUserDaoImpl.searchUserDaoIntance();
		list = dao.searchUser(userBean);
		
		
		return list;
	}

}
