package com.electrogrid.model;

public class Consumption {
	
	private int consumptionId;
	private int currentReading;
	private String currentReadDate;
	private int previousReading;
	private String previousReadDate;
	private int consumedUnits;
	private String month;
	private int accountId;
	
	public Consumption() {
		super();
	}

	public Consumption(int consumptionId, int currentReading, String currentReadDate, int previousReading,
			String previousReadDate, int consumedUnits, String month, int accountId) {
		super();
		this.consumptionId = consumptionId;
		this.currentReading = currentReading;
		this.currentReadDate = currentReadDate;
		this.previousReading = previousReading;
		this.previousReadDate = previousReadDate;
		this.consumedUnits = consumedUnits;
		this.month = month;
		this.accountId = accountId;
	}

	public int getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(int consumptionId) {
		this.consumptionId = consumptionId;
	}

	public int getCurrentReading() {
		return currentReading;
	}

	public void setCurrentReading(int currentReading) {
		this.currentReading = currentReading;
	}

	public String getCurrentReadDate() {
		return currentReadDate;
	}

	public void setCurrentReadDate(String currentReadDate) {
		this.currentReadDate = currentReadDate;
	}

	public int getPreviousReading() {
		return previousReading;
	}

	public void setPreviousReading(int previousReading) {
		this.previousReading = previousReading;
	}

	public String getPreviousReadDate() {
		return previousReadDate;
	}

	public void setPreviousReadDate(String previousReadDate) {
		this.previousReadDate = previousReadDate;
	}

	public int getConsumedUnits() {
		return consumedUnits;
	}

	public void setConsumedUnits(int consumedUnits) {
		this.consumedUnits = consumedUnits;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

}
