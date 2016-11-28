package com.ibm.cl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.cl.common.DBConnection;
import com.ibm.cl.dao.CampaignPageDao;
import com.ibm.cl.dto.CampaignDetailsDto;

public class CampaignPageDaoImpl implements CampaignPageDao {
	
	private static String CAMPAIGN_DETAILS_QUERY = "select * from CAMPAIGN_DETAILS";
	
	public ArrayList<CampaignDetailsDto> getCampaignDetails()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CampaignDetailsDto> campaignDetails = new ArrayList<CampaignDetailsDto>();
		CampaignDetailsDto  dto = null;
		try{
		con = DBConnection.getDBConnection();
		pstmt = con.prepareStatement("SELECT * FROM CAMPAIGN_DETAILS");
		//System.out.println(pstmt+"========"+con);
		rs = pstmt.executeQuery();
		//System.out.println("uiiiiiii"+rs.next());
		while(rs.next())
		{
			dto = new CampaignDetailsDto();
			dto.setMessage(rs.getString("MESSAGE"));
			dto.setValidFrom(rs.getString("VALIDFROM"));
			dto.setValidTo(rs.getString("VALIDTO"));
			campaignDetails.add(dto);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("uuuuuuuuuuuuuuuu");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.releaseResources(con, pstmt, rs);
		}
		System.out.println("inside dao");
		 return campaignDetails;
	}

}
