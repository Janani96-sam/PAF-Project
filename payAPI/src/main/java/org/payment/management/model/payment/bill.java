package org.payment.management.model.payment;

public class bill {
	
	int idpay_bill;
	String cus_id;
	String bill_no;
	String month;
	String tot_amount;
	String status;
	
	
	public bill() {
		
	}


	public bill(int idpay_bill, String cus_id, String bill_no, String month, String tot_amount, String status) {
		super();
		this.idpay_bill = idpay_bill;
		this.cus_id = cus_id;
		this.bill_no = bill_no;
		this.month = month;
		this.tot_amount = tot_amount;
		this.status = status;
	}


	public bill(String cus_id, String bill_no, String month, String tot_amount, String status) {
		super();
		this.cus_id = cus_id;
		this.bill_no = bill_no;
		this.month = month;
		this.tot_amount = tot_amount;
		this.status = status;
	}


	public int getIdpay_bill() {
		return idpay_bill;
	}


	public void setIdpay_bill(int idpay_bill) {
		this.idpay_bill = idpay_bill;
	}


	public String getCus_id() {
		return cus_id;
	}


	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}


	public String getBill_no() {
		return bill_no;
	}


	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getTot_amount() {
		return tot_amount;
	}


	public void setTot_amount(String tot_amount) {
		this.tot_amount = tot_amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
