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
			
		preparedStatement.setInt(Constant.INDEX_ONE, consumption.getCurrentReading());
		preparedStatement.setString(Constant.INDEX_TWO, consumption.getCurrentReadDate());
		preparedStatement.setInt(Constant.INDEX_THREE, consumption.getPreviousReading());
		preparedStatement.setString(Constant.INDEX_FOUR, consumption.getPreviousReadDate());
		preparedStatement.setInt(Constant.INDEX_FIVE, consumption.getConsumedUnits());
		preparedStatement.setString(Constant.INDEX_SIX, consumption.getMonth());
		preparedStatement.setInt(Constant.INDEX_SEVEN, consumption.getAccountId());
			  
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
			consumption.setCurrentReading(rs.getInt(Constant.INDEX_TWO));
			consumption.setCurrentReadDate(rs.getString(Constant.INDEX_THREE));
			consumption.setPreviousReading(rs.getInt(Constant.INDEX_FOUR));
			consumption.setPreviousReadDate(rs.getString(Constant.INDEX_FIVE));
			consumption.setConsumedUnits(rs.getInt(Constant.INDEX_SIX));
			consumption.setMonth(rs.getString(Constant.INDEX_SEVEN));
			consumption.setAccountId(rs.getInt(Constant.INDEX_EIGHT));
				
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
			int currentReading = rs.getInt(Constant.INDEX_TWO);
			String currentReadDate = rs.getString(Constant.INDEX_THREE);
			int previousReading = rs.getInt(Constant.INDEX_FOUR);
			String previousReadDate = rs.getString(Constant.INDEX_FIVE);
			int consumedUnits = rs.getInt(Constant.INDEX_SIX);
			String month = rs.getString(Constant.INDEX_SEVEN);
			int accountId = rs.getInt(Constant.INDEX_EIGHT);
			
			consumption = new Consumption(consumptionId, currentReading, currentReadDate, previousReading, previousReadDate, consumedUnits, month, accountId);
		}
		return consumption;
				
	}
	
	//update a consumption
	public static Consumption updateConsumption(Consumption consumption,int conId) throws SQLException, ClassNotFoundException {
			
		String update_query = ConsumptionConstant.UPDATECONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, consumption.getCurrentReading());
		preparedStatement.setString(Constant.INDEX_TWO, consumption.getCurrentReadDate());
		preparedStatement.setInt(Constant.INDEX_THREE, consumption.getPreviousReading());
		preparedStatement.setString(Constant.INDEX_FOUR, consumption.getPreviousReadDate());
		preparedStatement.setInt(Constant.INDEX_FIVE, consumption.getConsumedUnits());
		preparedStatement.setString(Constant.INDEX_SIX, consumption.getMonth());
		preparedStatement.setInt(Constant.INDEX_SEVEN, consumption.getAccountId());
		
		preparedStatement.setInt(Constant.INDEX_EIGHT, conId);
				
		if(preparedStatement.executeUpdate() > 0) {
			return getConsumption(conId);
		}
		else {
			return null;
		}
				
	}
	
	//delete a consumption
	public static boolean deleteConsumption(int conId) throws SQLException, ClassNotFoundException {
				
		String delete_query = ConsumptionConstant.DELETECONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, conId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}
		
	//get a consumption by account id
	public static Consumption getConsumptionByAccId(int accId) throws SQLException, ClassNotFoundException {
						
		String getdata_query = ConsumptionConstant.GETCONSUMPTIONBYACC;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
						
		Consumption consumption = null;
						
		preparedStatement.setInt(Constant.INDEX_ONE, accId);
					
		ResultSet rs = preparedStatement.executeQuery();
						
		while(rs.next()) {
			int consumptionId = rs.getInt(Constant.INDEX_ONE);
			int currentReading = rs.getInt(Constant.INDEX_TWO);
			String currentReadDate = rs.getString(Constant.INDEX_THREE);
			int previousReading = rs.getInt(Constant.INDEX_FOUR);
			String previousReadDate = rs.getString(Constant.INDEX_FIVE);
			int consumedUnits = rs.getInt(Constant.INDEX_SIX);
			String month = rs.getString(Constant.INDEX_SEVEN);
			int accountId = rs.getInt(Constant.INDEX_EIGHT);
			
			consumption = new Consumption(consumptionId, currentReading, currentReadDate, previousReading, previousReadDate, consumedUnits, month, accountId);
		}
		return consumption;
						
	}	 	
					
		
}
