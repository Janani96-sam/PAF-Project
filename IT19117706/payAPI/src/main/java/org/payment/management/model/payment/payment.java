package org.payment.management.model.payment;

public class payment {
	
	int idbill;
	String cus_id;
	String last_bill;
	String this_bill;
	String last_payment;
	String unit_price;
	
	
	public payment() {
		
	}
	
	public payment(String cus_id, String last_bill, String this_bill, String last_payment, String unit_price) {
		super();
		this.cus_id = cus_id;
		this.last_bill = last_bill;
		this.this_bill = this_bill;
		this.last_payment = last_payment;
		this.unit_price = unit_price;
	}
	
	public payment(int idbill,String cus_id, String last_bill, String this_bill, String last_payment, String unit_price) {
		super();
		this.idbill = idbill;
		this.cus_id = cus_id;
		this.last_bill = last_bill;
		this.this_bill = this_bill;
		this.last_payment = last_payment;
		this.unit_price = unit_price;
	}

	public int getIdbill() {
		return idbill;
	}

	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getLast_bill() {
		return last_bill;
	}

	public void setLast_bill(String last_bill) {
		this.last_bill = last_bill;
	}

	public String getThis_bill() {
		return this_bill;
	}

	public void setThis_bill(String this_bill) {
		this.this_bill = this_bill;
	}

	public String getLast_payment() {
		return last_payment;
	}

	public void setLast_payment(String last_payment) {
		this.last_payment = last_payment;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	
	
	
}
