package com.electrogrid.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.electrogrid.constant.Constant;
import com.electrogrid.constant.InterruptionConstant;
import com.electrogrid.model.Interruption;
import com.electrogrid.util.DatabaseConnection;

public class InterruptionService {
	
	//create an interruption
		public static Interruption createInterruption(Interruption interruption) throws SQLException, ClassNotFoundException {
				
			System.out.println(interruption);
			String create_query = InterruptionConstant.CREATEINTERRUPTION;
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(create_query);
				
			preparedStatement.setString(Constant.INDEX_ONE, interruption.getDate());
			preparedStatement.setString(Constant.INDEX_TWO, interruption.getTime());
			preparedStatement.setString(Constant.INDEX_THREE, interruption.getPremisesID());
			preparedStatement.setString(Constant.INDEX_FOUR, interruption.getArea());
			preparedStatement.setString(Constant.INDEX_FIVE, interruption.getReason());
			preparedStatement.setString(Constant.INDEX_SIX, interruption.getStatus());
				  
			boolean isCreated = preparedStatement.execute();
			System.out.println(isCreated);
			
			if(!isCreated) {
				return interruption;
			}
			else {
				return null;
			}
				
		}
		
		//get all interruptions
		public static ArrayList<Interruption> getInterruptions() throws ClassNotFoundException, SQLException {
				
			ArrayList<Interruption> clist = new ArrayList<>();
			String get_query = InterruptionConstant.GETALLINTERRUPTIONS;
			Connection con = DatabaseConnection.getConnection();
				
			PreparedStatement preparedStatement = con.prepareStatement(get_query);
			ResultSet rs = preparedStatement.executeQuery();
				
			while(rs.next()) {
				Interruption interruption = new Interruption();
					
				interruption.setInterruptionID(rs.getInt(Constant.INDEX_ONE));
				interruption.setDate(rs.getString(Constant.INDEX_TWO));
				interruption.setTime(rs.getString(Constant.INDEX_THREE));
				interruption.setPremisesID(rs.getString(Constant.INDEX_FOUR));
				interruption.setArea(rs.getString(Constant.INDEX_FIVE));
				interruption.setReason(rs.getString(Constant.INDEX_SIX));
				interruption.setStatus(rs.getString(Constant.INDEX_SEVEN));
					
				clist.add(interruption);
			}
			return  clist;
				
		}
			
		//get an interruption by interruption id
		public static Interruption getInterruption(int intId) throws SQLException, ClassNotFoundException {
					
			String getdata_query = InterruptionConstant.GETINTERRUPTIONBYID;
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
					
			Interruption interruption = null;
					
			preparedStatement.setInt(Constant.INDEX_ONE, intId);
					
			ResultSet rs = preparedStatement.executeQuery();
					
			while(rs.next()) {
				int interruptionID = rs.getInt(Constant.INDEX_ONE);
				String date = rs.getString(Constant.INDEX_TWO);
				String time = rs.getString(Constant.INDEX_THREE);
				String premisesID = rs.getString(Constant.INDEX_FOUR);
				String area = rs.getString(Constant.INDEX_FIVE);
				String reason = rs.getString(Constant.INDEX_SIX);
				String status = rs.getString(Constant.INDEX_SEVEN);
				
				
				interruption = new Interruption(interruptionID, date, time, premisesID, area, reason, status);
			}
			return interruption;
					
		}
		
		//update an interruption
		public static Interruption updateInterruption(Interruption interruption,int intId) throws SQLException, ClassNotFoundException {
						
			String update_query = InterruptionConstant.UPDATEINTERRUPTION;
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(update_query);
							
					preparedStatement.setString(Constant.INDEX_ONE, interruption.getDate());
					preparedStatement.setString(Constant.INDEX_TWO, interruption.getTime());
					preparedStatement.setString(Constant.INDEX_THREE, interruption.getPremisesID());
					preparedStatement.setString(Constant.INDEX_FOUR, interruption.getArea());
					preparedStatement.setString(Constant.INDEX_FIVE, interruption.getReason());
					preparedStatement.setString(Constant.INDEX_SIX, interruption.getStatus());
					
					preparedStatement.setInt(Constant.INDEX_SEVEN, intId);
							
					if(preparedStatement.executeUpdate() > 0) {
						return getInterruption(intId);
					}
					else {
						return null;
					}
							
				}
				
		 //delete an interruption
		public static boolean deleteInterruption(int intId) throws SQLException, ClassNotFoundException {
							
			String delete_query = InterruptionConstant.DELETEINTERRUPTION;
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(delete_query);
							
					preparedStatement.setInt(Constant.INDEX_ONE, intId);
					boolean isDeleted = preparedStatement.execute();
							
					return isDeleted;
							
				}

}
