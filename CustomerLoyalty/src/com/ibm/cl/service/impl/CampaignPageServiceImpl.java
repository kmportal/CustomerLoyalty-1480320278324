package com.ibm.cl.service.impl;

import java.util.ArrayList;

import com.ibm.cl.dao.CampaignPageDao;
import com.ibm.cl.dao.impl.CampaignPageDaoImpl;
import com.ibm.cl.dto.CampaignDetailsDto;
import com.ibm.cl.service.CampaignPageService;

public class CampaignPageServiceImpl implements CampaignPageService{

	public ArrayList<CampaignDetailsDto> getCampaignDetails()
	{
		CampaignPageDao  dao = new CampaignPageDaoImpl();
		ArrayList<CampaignDetailsDto> campaignDetails = dao.getCampaignDetails();
		return campaignDetails;
	}
}
