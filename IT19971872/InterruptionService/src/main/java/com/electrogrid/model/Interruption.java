package com.electrogrid.model;

public class Interruption {
	
	private int interruptionID;
	private String date;
	private String time;
	private String premisesID;
	private String area;
	private String reason;
	private String status;
	
	public Interruption() {
		super();
	}

	public Interruption(int interruptionID, String date, String time, String premisesID, String area, String reason,
			String status) {
		super();
		this.interruptionID = interruptionID;
		this.date = date;
		this.time = time;
		this.premisesID = premisesID;
		this.area = area;
		this.reason = reason;
		this.status = status;
	}

	public int getInterruptionID() {
		return interruptionID;
	}

	public void setInterruptionID(int interruptionID) {
		this.interruptionID = interruptionID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPremisesID() {
		return premisesID;
	}

	public void setPremisesID(String premisesID) {
		this.premisesID = premisesID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}


