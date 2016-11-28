package com.ibm.cl.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.ibm.cl.common.DBConnection;
import com.ibm.cl.dao.UserRegistrationDao;
import com.ibm.cl.dto.ProductDto;
import com.ibm.cl.dto.UserRegistrationDto;
import com.ibm.cl.forms.UserRegistrationFormBean;
import com.ibm.core.exception.DAOException;


public class UserRegistrationDaoImpl implements UserRegistrationDao {
	
private static UserRegistrationDaoImpl userRegistrationDaoImpl=null;
	
	private UserRegistrationDaoImpl(){
		
	}
	
	public static UserRegistrationDaoImpl userRegistrationDaoInstance()
	{
		if(userRegistrationDaoImpl==null)
		{
			userRegistrationDaoImpl=new UserRegistrationDaoImpl();
		}
		return userRegistrationDaoImpl;
		
	}

	public ArrayList<UserRegistrationDto> createUser(UserRegistrationFormBean userBean) throws DAOException {
		
		Connection con =null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		//UserRegistrationDto dto = null;
		ArrayList<UserRegistrationDto> returnUserRegistrationDto = new ArrayList<UserRegistrationDto>();
		try{
			UserRegistrationDto userdto = new UserRegistrationDto();
			con = DBConnection.getDBConnection();
			ps1=con.prepareStatement("SELECT * FROM CL_USR_MASTER WHERE MOBILE_NUMBER=?");
			ps=con.prepareStatement("INSERT INTO CL_USR_MASTER(FIRST_NAME, LAST_NAME, MOBILE_NUMBER, EMAIL_ID, ADDRESS, CARD_NUMBER, USER_STATE, CREATED_BY, CREATED_DATE, PINCODE)" 
    +"VALUES( ?, ?, ?,?, ?,?,?,?, current_timestamp, ?)");
			
			ps1.setLong(1, userBean.getMobileNumber());
			rs=ps1.executeQuery();
			System.out.println("Execute RS");
			if(rs.next()){
				
				userdto.setCardNumber(rs.getString("CARD_NUMBER"));
				userdto.setMessage("Your mobile number is already registered");
			}
			
			else{
				
				
				 Random rand = new Random();
					String cardNumber ;
					String randNo="";
					
					int randNumber=rand.nextInt(99999999);
					if(randNumber < 10000000)
					{
						Integer newRand=rand.nextInt(9);
						randNo=randNo+newRand;
						randNo=randNo+randNumber;		
					}
					else
						randNo=randNo+randNumber;
					String number  = ((Long)userBean.getMobileNumber()).toString();
					cardNumber = number+randNo;
					
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+cardNumber);
				
				
			ps.setString(1,userBean.getFirstName());
			ps.setString(2,userBean.getLastName());
			ps.setLong(3,userBean.getMobileNumber());
			ps.setString(4, userBean.getEmail());
			ps.setString(5, userBean.getAddress());
			ps.setString(6, cardNumber);
			ps.setString(7,userBean.getState());
			ps.setString(8,"cl_user");
			ps.setInt(9,1234567	);
			ps.executeUpdate();
			System.out.println("Executed");
			userdto.setCardNumber(cardNumber);
			userdto.setMessage("Registration is successful");
			}
			returnUserRegistrationDto.add(userdto);
			return returnUserRegistrationDto;
			
		}
		catch(Exception e){
			e.printStackTrace();
			UserRegistrationDto userDTO = new UserRegistrationDto();
			userDTO.setMessage("User creation failed");
			returnUserRegistrationDto.add(userDTO);
		}
		return returnUserRegistrationDto;
	}
	
	public String addProduct(int prodId,String mobNo){
		String message="";
		
		
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
			ps=conn.prepareStatement("INSERT INTO CL_LINK_MASTER(USER_ID,PRODUCT_TYPE,MOBILE_NO,CREATED_DT,STATUS) VALUES(?,?,?,current date,'A')");
			ps.setString(1, mobNo);
			ps.setInt(2,prodId);
			ps.setString(3, mobNo);
			int noRec=ps.executeUpdate();
			if(noRec>0){
				message="Product Added!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.releaseResources(conn, ps, rs);
		}
		
		return message;
		
		
		
	}
	@Override
	public String validate(String mobNo){
		String message="_";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			conn=DBConnection.getDBConnection();
		}catch(DAOException daoEx){
			daoEx.printStackTrace();
			throw new DAOException(daoEx.getMessage());
			}
		
		try {
			ps=conn.prepareStatement("SELECT * from CL_USR_MASTER WHERE MOBILE_NUMBER=?");
			ps.setString(1, mobNo);
			rs=ps.executeQuery();
			if(rs.next()){
				message="";
			}
			
			else
				message="This mobile no. is not registered";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.releaseResources(conn, ps, rs);
		}
		
		return message;
	}

	@Override
	public String userLoginAuthenticate(String user, String pass) throws DAOException {
		// TODO Auto-generated method stub

			String message="";
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try{
				conn=DBConnection.getDBConnection();
			}catch(DAOException daoEx){
				daoEx.printStackTrace();
				throw new DAOException(daoEx.getMessage());
				}
			
			try {
				ps=conn.prepareStatement("SELECT PASSWORD from CL_USR_MASTER WHERE MOBILE_NUMBER=?");
				ps.setString(1, user);
				rs=ps.executeQuery();
				if(rs.next()){
					String passDec=rs.getString("PASSWORD");
					if(pass.equals(passDec)){
						return "Valid";
					}
					else
						message="password invalid";
				}
				
				else
					message="Login id password combination not valid";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DBConnection.releaseResources(conn, ps, rs);
			}
			
			return message;
	}
	
	public int fetchRole(String userName){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int level=0;
		
		try{
			conn=DBConnection.getDBConnection();
		}catch(DAOException daoEx){
			daoEx.printStackTrace();
			throw new DAOException(daoEx.getMessage());
			}
		
		try {
			ps=conn.prepareStatement("SELECT LEVEL_ID from CL_USR_MASTER WHERE MOBILE_NUMBER=?");
			ps.setString(1, userName);
			rs=ps.executeQuery();
			if(rs.next()){
				level=rs.getInt("LEVEL_ID");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.releaseResources(conn, ps, rs);
		}
		
		return level;
		
	}


}
