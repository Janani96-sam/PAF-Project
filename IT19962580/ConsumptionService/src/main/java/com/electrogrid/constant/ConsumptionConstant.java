package com.electrogrid.constant;

public class ConsumptionConstant {
	
	public static String CREATECONSUMPTION = "INSERT INTO consumption (units,month,premisesId,readDate,accountId) VALUES (?,?,?,?,?)";
	public static String GETALLCONSUMPTIONS = "SELECT * FROM consumption";
	public static String GETCONSUMPTIONBYID = "SELECT * FROM consumption WHERE consumptionId = ?";
	public static String UPDATECONSUMPTION = "UPDATE consumption SET units = ? , month = ? , premisesId = ? , readDate = ? , accountId = ? WHERE consumptionId = ?";
	public static String DELETECONSUMPTION = "DELETE FROM consumption WHERE consumptionId = ?";
	public static String GETCONSUMPTIONBYACC = "SELECT * FROM consumption WHERE accountId = ?";

}
