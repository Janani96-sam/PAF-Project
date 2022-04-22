package com.electrogrid.constant;

public class ConsumptionConstant {
	
	public static String CREATECONSUMPTION = "INSERT INTO consumption (consumptionId,units,month,premisesId,readDate,accId) VALUES (?,?,?,?,?,?)";
	public static String GETALLCONSUMPTIONS = "SELECT * FROM consumption";
	public static String GETCONSUMPTIONBYID = "SELECT * FROM consumption WHERE id = ?";
	public static String UPDATECONSUMPTION = "UPDATE consumption SET units = ? , month = ? , premisesId = ? , readDate = ? , accId = ? WHERE consumptionId = ?";
	public static String DELETECONSUMPTION = "DELETE FROM consumption WHERE consumptionId = ?";

}
