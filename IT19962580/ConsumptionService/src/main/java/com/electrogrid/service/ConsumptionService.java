package com.electrogrid.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.electrogrid.constant.Constant;
import com.electrogrid.constant.ConsumptionConstant;
import com.electrogrid.model.Consumption;
import com.electrogrid.util.DatabaseConnection;

public class ConsumptionService {
	
	//create a consumption
	public static Consumption createConsumption(Consumption consumption) throws SQLException, ClassNotFoundException {
			
		String create_query = ConsumptionConstant.CREATECONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(create_query);
			
		preparedStatement.setInt(Constant.INDEX_ONE, consumption.getUnits());
		preparedStatement.setString(Constant.INDEX_TWO, consumption.getMonth());
		preparedStatement.setString(Constant.INDEX_THREE, consumption.getPremisesId());
		preparedStatement.setString(Constant.INDEX_FOUR, consumption.getReadDate());
		preparedStatement.setInt(Constant.INDEX_FIVE, consumption.getAccId());
			  
		boolean isCreated = preparedStatement.execute();
		System.out.println(isCreated);
		
		if(!isCreated) {
			return consumption;
		}
		else {
			return null;
		}
			
	}
	
	//get all consumptions
	public static ArrayList<Consumption> getConsumptions() throws ClassNotFoundException, SQLException {
			
		ArrayList<Consumption> clist = new ArrayList<>();
		String get_query = ConsumptionConstant.GETALLCONSUMPTIONS;
		Connection con = DatabaseConnection.getConnection();
			
		PreparedStatement preparedStatement = con.prepareStatement(get_query);
		ResultSet rs = preparedStatement.executeQuery();
			
		while(rs.next()) {
			Consumption consumption = new Consumption();
				
			consumption.setConsumptionId(rs.getInt(Constant.INDEX_ONE));
			consumption.setUnits(rs.getInt(Constant.INDEX_TWO));
			consumption.setMonth(rs.getString(Constant.INDEX_THREE));
			consumption.setPremisesId(rs.getString(Constant.INDEX_FOUR));
			consumption.setReadDate(rs.getString(Constant.INDEX_FIVE));
			consumption.setAccId(rs.getInt(Constant.INDEX_SIX));
				
			clist.add(consumption);
		}
		return  clist;
			
	}
		
	//get a consumption by consumption id
	public static Consumption getConsumption(int conId) throws SQLException, ClassNotFoundException {
				
		String getdata_query = ConsumptionConstant.GETCONSUMPTIONBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Consumption consumption = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, conId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int consumptionId = rs.getInt(Constant.INDEX_ONE);
			int units = rs.getInt(Constant.INDEX_TWO);
			String month = rs.getString(Constant.INDEX_THREE);
			String premisesId = rs.getString(Constant.INDEX_FOUR);
			String readDate = rs.getString(Constant.INDEX_FIVE);
			int accId = rs.getInt(Constant.INDEX_SIX);
			
			consumption = new Consumption(consumptionId, units, month, premisesId, readDate, accId);
		}
		return consumption;
				
	}
					
		
}
