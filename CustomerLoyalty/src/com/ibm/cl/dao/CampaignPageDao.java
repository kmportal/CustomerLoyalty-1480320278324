package com.ibm.cl.dao;

import java.util.ArrayList;

import com.ibm.cl.dto.CampaignDetailsDto;

public interface CampaignPageDao {
	public ArrayList<CampaignDetailsDto> getCampaignDetails();

}
