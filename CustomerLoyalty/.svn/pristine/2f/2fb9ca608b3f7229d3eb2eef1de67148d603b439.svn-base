package com.ibm.cl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ibm.cl.common.DBConnection;
import com.ibm.cl.dao.BusinessCriteriaDao;
import com.ibm.cl.forms.BusinessCriteriaFormBean;
import com.ibm.core.exception.DAOException;

public class BusinessCriteriaDaoImpl implements BusinessCriteriaDao {

	private static BusinessCriteriaDaoImpl businessCriteriaDaoImpl = null;

	private BusinessCriteriaDaoImpl() {

	}

	public static BusinessCriteriaDaoImpl businessCriteriaDaoInstance() {
		if (businessCriteriaDaoImpl == null) {
			businessCriteriaDaoImpl = new BusinessCriteriaDaoImpl();
		}
		return businessCriteriaDaoImpl;

	}

	public boolean addCriteria(BusinessCriteriaFormBean businessCriteriaBean) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			con = DBConnection.getDBConnection();

			ps1 = con.prepareStatement(
					"delete from THRESHOLD_MASTER where PRODUCT_TYPE="+businessCriteriaBean.getProductVal()+" ");
			
			ps1.executeUpdate();
			
			ps = con.prepareStatement(
					"INSERT INTO THRESHOLD_MASTER( PRODUCT_TYPE, AMOUNT,STATUS, POINTS, CREATED_DT)"
							+ "VALUES( ?, ?,'A', ?,current_timestamp)");

			System.out.println(" businessCriteriaBean.getProductVal() "+businessCriteriaBean.getProductVal());
			System.out.println("businessCriteriaBean.getPoints() "+businessCriteriaBean.getPoints());
			System.out.println("businessCriteriaBean.getUsageAmount() "+businessCriteriaBean.getUsageAmount());
			
			ps.setString(1, businessCriteriaBean.getProductVal());
			ps.setInt(2, businessCriteriaBean.getUsageAmount());
			ps.setString(3, businessCriteriaBean.getPoints());
			ps.executeUpdate();
			System.out.println("Criteria Added Succesfully ");
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public BusinessCriteriaFormBean fetchCriteria(BusinessCriteriaFormBean criteriaBean) throws DAOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = DBConnection.getDBConnection();

			ps = con.prepareStatement("Select AMOUNT,POINTS From THRESHOLD_MASTER WHERE PRODUCT_TYPE = "+criteriaBean.getProductVal()+"");

			rs=ps.executeQuery();
			System.out.println("Criteria Added Succesfully ");

			if(rs.next())
			{
				criteriaBean.setUsageAmount(rs.getInt(1));
				criteriaBean.setPoints(rs.getString(2));
			}
			

		} catch (Exception e) {
			e.printStackTrace();

		}
			
		return criteriaBean;
	}

}
