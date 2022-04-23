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
		
}
