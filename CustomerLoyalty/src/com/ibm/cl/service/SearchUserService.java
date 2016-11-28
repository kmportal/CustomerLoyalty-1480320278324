package com.ibm.cl.service;

import java.util.ArrayList;

import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;

public interface SearchUserService {

	public ArrayList<UserRegistrationDto> searchUser(UserRegistrationFormBean userBean);
}
