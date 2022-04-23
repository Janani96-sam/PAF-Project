package com.electrogrid.constant;

public class InterruptionConstant {

	public static String CREATEINTERRUPTION = "INSERT INTO interruption (date,time,premisesID,area,reason,status) VALUES (?,?,?,?,?,?)";
	public static String GETALLINTERRUPTIONS = "SELECT * FROM interruption";
	public static String GETINTERRUPTIONBYID = "SELECT * FROM interruption WHERE interruptionID = ?";
	public static String UPDATEINTERRUPTION = "UPDATE interruption SET date = ? , time = ? , premisesID = ? , area = ? , reason = ? , status = ?  WHERE interruptionID = ?";
	public static String DELETEINTERRUPTION = "DELETE FROM interruption WHERE interruptionID = ?";
	
}
