package com.ibm.cl.service.impl;

import java.util.ArrayList;
import com.ibm.cl.dao.ReferralDao;
import com.ibm.cl.dao.impl.ReferralDaoImpl;
import com.ibm.cl.dto.ReferralDto;
import com.ibm.cl.forms.ReferralFormBean;
import com.ibm.cl.service.ReferralService;


public class ReferralServiceImpl  implements ReferralService{
	
	public ArrayList<ReferralDto> referUserProducts(){
		ArrayList<ReferralDto> list = new ArrayList<ReferralDto>();
		ReferralDto dto = null;
		ReferralDao dao = ReferralDaoImpl.referralDaoIntance();
		list = dao.referUserProducts();
		return list;
		
	}
	
	public String referedUserCreation(ReferralFormBean userBean){
		
		ReferralDao dao = ReferralDaoImpl.referralDaoIntance();
		String userProduct=dao.referedUserCreation(userBean);
		return userProduct;
		
	}

}
