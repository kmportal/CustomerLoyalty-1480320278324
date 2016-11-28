package com.ibm.cl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.cl.common.DBConnection;
import com.ibm.cl.dao.ReferralDao;
import com.ibm.cl.dto.ReferralDto;
import com.ibm.cl.forms.ReferralFormBean;
import com.ibm.core.exception.DAOException;

public class ReferralDaoImpl implements  ReferralDao{
	

	private static ReferralDaoImpl referralDaoImpl=null;
		
		private ReferralDaoImpl(){
			
		}
		
		public static ReferralDaoImpl referralDaoIntance()
		{
			if(referralDaoImpl==null)
			{
				referralDaoImpl=new ReferralDaoImpl();
			}
			return referralDaoImpl;
			
		}
	
	
	
	
	public ArrayList<ReferralDto> referUserProducts() throws DAOException{

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ReferralDto referralDto=null;
		ArrayList<ReferralDto> listOfproduct=new ArrayList<ReferralDto>();
		try {
			StringBuffer query= new StringBuffer("SELECT * FROM LOYALITY_PROD_MSTR "); 
			con = DBConnection.getDBConnection();
			pst = con.prepareStatement(query.append(" with ur ").toString());
			
			rs = pst.executeQuery();
			while(rs.next()) {
				referralDto=new ReferralDto();
				referralDto.setProductId(rs.getInt(1));
				referralDto.setProductName(rs.getString(2));
				listOfproduct.add(referralDto);
			}
			
			/* for(int i = 0; i < listOfproduct.size(); i++) {
		            System.out.println(listOfproduct.get(i).getProductId()+"====DAOIMPL==========="+listOfproduct.get(i).getProductName());
		        }*/
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				//DBConnection.releaseResources(con, pst, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listOfproduct;
	}
	
	public String referedUserCreation(ReferralFormBean userBean)throws DAOException{
		StringBuffer insertStatus = new StringBuffer("INSERT_FAILURE") ;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println("=================================================="+userBean.getProductId());
		try {
			StringBuffer query= new StringBuffer("INSERT INTO LMS_LEAD_DATA( CUSTOMER_NAME,PRODUCT_ID ,MOBILE_NUMBER, ADDRESS,ALTERNATE_MOBILE_NUMBER , CIRCLE)VALUES(?,?,?,?,?,?)"); 
			con = DBConnection.getDBConnection();
			pst = con.prepareStatement(query.toString());
			pst.setString(1,userBean.getCustomerName());
			pst.setInt(2, Integer.parseInt(userBean.getProductId()));
			pst.setString(3, userBean.getMobileNumber());
			pst.setString(4, userBean.getAddress());
			pst.setString(5, userBean.getAlternatemobileNumber());
			pst.setString(6, userBean.getCircle());
			
			int count = pst.executeUpdate();
			if(count>0){
				insertStatus.delete(0,14);  // remove INSERT_FAILURE
				insertStatus.append("LEAD_CREATED_SUCCESSFULLY");
				return insertStatus.toString();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				//DBConnection.releaseResources(con, pst, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertStatus.toString();
		
	}
	
	
	

}
