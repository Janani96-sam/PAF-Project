package com.electrogrid.model;

public class Consumption {
	
	private int consumptionId;
	private int units;
	private String month;
	private String premisesId;
	private String readDate;
	private int accId;
	
	public Consumption() {
		super();
	}

	public Consumption(int consumptionId, int units, String month, String premisesId, String readDate, int accId) {
		super();
		this.consumptionId = consumptionId;
		this.units = units;
		this.month = month;
		this.premisesId = premisesId;
		this.readDate = readDate;
		this.accId = accId;
	}

	public int getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(int consumptionId) {
		this.consumptionId = consumptionId;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(String premisesId) {
		this.premisesId = premisesId;
	}

	public String getReadDate() {
		return readDate;
	}

	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

}
