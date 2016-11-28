package com.ibm.cl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ibm.cl.dao.SearchUserDao;
import com.ibm.cl.dto.ProductDto;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.core.exception.DAOException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.cl.common.DBConnection;
import com.ibm.cl.dao.UserRegistrationDao;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.core.exception.DAOException;


public class SearchUserDaoImpl implements SearchUserDao {
	
	
	private static SearchUserDaoImpl searchUserDaoImpl=null;
		
		private SearchUserDaoImpl(){
			
		}
		
		public static SearchUserDaoImpl searchUserDaoIntance()
		{
			if(searchUserDaoImpl==null)
			{
				searchUserDaoImpl=new SearchUserDaoImpl();
			}
			return searchUserDaoImpl;
			
		}

		public ArrayList<UserRegistrationDto> searchUser(UserRegistrationFormBean userBean) throws DAOException {
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			PreparedStatement ps3 = null;
			java.sql.Connection con = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			String card = null;
			UserRegistrationDto dto = new UserRegistrationDto();
			//UserRegistrationDto dto =null;
			ArrayList<UserRegistrationDto> returnUserSearchList = new ArrayList<UserRegistrationDto>();
			try{
			
				con = DBConnection.getDBConnection();
				ps = con.prepareStatement("SELECT * FROM CL_USR_MASTER WHERE MOBILE_NUMBER=? with UR");
				ps1 = con.prepareStatement("SELECT * FROM CL_USR_MASTER WHERE CARD_NUMBER=? with UR");
				ps2 = con.prepareStatement("SELECT * FROM CL_USR_MASTER WHERE CARD_NUMBER=? and MOBILE_NUMBER=? with UR");
				ps3 = con.prepareStatement("SELECT * FROM REWARD_POINTS WHERE CARD_NUMBER = ? with UR");
				//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1"+userBean.getCardNumber());
				//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11"+userBean.getMobileNumber());
				if(userBean.getCardNumber()== null ){
					ps.setLong(1, userBean.getMobileNumber());
					rs = ps.executeQuery();
					if(rs.next()){
						String name = rs.getString("FIRST_NAME");
						String l_name = rs.getString("LAST_NAME");
						String mobile = rs.getString("MOBILE_NUMBER");
						card = rs.getString("CARD_NUMBER");
						String email = rs.getString("EMAIL_ID");
						dto.setCardNumber(card);
						dto.setMobileNumber(Long.parseLong(mobile));
						dto.setFirstName(name);
						dto.setLastName(l_name);
						dto.setEmail(email);
						
						
						//String points = rs.getString("");
					}
					
					
					
				}
				else if(userBean.getMobileNumber()==0){
					ps1.setString(1, userBean.getCardNumber());
					rs1 = ps1.executeQuery();
					if(rs1.next()){
					String name = rs1.getString("FIRST_NAME");
					String l_name = rs1.getString("LAST_NAME");
					String mobile = rs1.getString("MOBILE_NUMBER");
					card = rs1.getString("CARD_NUMBER");
					String email = rs1.getString("EMAIL_ID");
					dto.setCardNumber(card);
					dto.setMobileNumber(Long.parseLong(mobile));
					dto.setFirstName(name);
					dto.setLastName(l_name);
					dto.setEmail(email);
					}
					
				}
				else {
					ps2.setString(1, userBean.getCardNumber());
					ps2.setLong(2,userBean.getMobileNumber());
					rs2=ps2.executeQuery();
					if(rs2.next()){
					String name = rs2.getString("FIRST_NAME");
					String l_name = rs2.getString("LAST_NAME");
					String mobile = rs2.getString("MOBILE_NUMBER");
					card = rs2.getString("CARD_NUMBER");
					String email = rs2.getString("EMAIL_ID");
					dto.setEmail(email);
					dto.setCardNumber(card);
					dto.setMobileNumber(Long.parseLong(mobile));
					dto.setFirstName(name);
					dto.setLastName(l_name);
					}
				}
				
				if (card!=""){
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^"+card);
					ps3.setString(1, card);
					rs3=ps3.executeQuery();
					if(rs3.next()){
						int points = rs3.getInt("POINTS_REWARDED");
						//String updated = rs.getString(3);
						dto.setPointsRewarded(points);
						System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+points);
						//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+updated);
						
					}
					
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
					con.close();
					DBConnection.releaseResources(con, ps, rs);
					DBConnection.releaseResources(null, ps1, rs1);
					DBConnection.releaseResources(null, ps2, rs2);
					DBConnection.releaseResources(null, ps3, rs3);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			returnUserSearchList.add(dto);
			return returnUserSearchList;
		}

		@Override
		public ArrayList<ProductDto> fetchProducts() throws DAOException {
			
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<ProductDto> productList=new ArrayList<ProductDto>();
			
			try{
				conn=DBConnection.getDBConnection();
			}catch(DAOException daoEx){
				daoEx.printStackTrace();
				throw new DAOException(daoEx.getMessage());
				}
			
			try {
				ps=conn.prepareStatement("SELECT PRODUCT_ID,PRODUCT_NAME FROM PRODUCT_MASTER");
				rs=ps.executeQuery();
				while(rs.next()){
					ProductDto product=new ProductDto();
					product.setProductId(rs.getInt("PRODUCT_ID"));
					product.setProductName(rs.getString("PRODUCT_NAME"));
					productList.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DBConnection.releaseResources(conn, ps, rs);
			}
			
			return productList;
		}

}
