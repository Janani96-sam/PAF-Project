package com.pojo;

public class Customer {
private int cid;
private String title;
private String fname;
private String lname;
private String cus_nic;
private String contact_number;
private String address;
private String cus_email;
private int cus_status;
private int employee_eid;
public Customer() {
	super();
}




public Customer(int cid, String title, String fname, String lname, String cus_nic, String contact_number,
		String address, String cus_email, int cus_status, int employee_eid) {
	super();
	this.cid = cid;
	this.title = title;
	this.fname = fname;
	this.lname = lname;
	this.cus_nic = cus_nic;
	this.contact_number = contact_number;
	this.address = address;
	this.cus_email = cus_email;
	this.cus_status = cus_status;
	this.employee_eid = employee_eid;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getCus_nic() {
	return cus_nic;
}

public void setCus_nic(String cus_nic) {
	this.cus_nic = cus_nic;
}

public String getContact_number() {
	return contact_number;
}

public void setContact_number(String contact_number) {
	this.contact_number = contact_number;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCus_email() {
	return cus_email;
}

public void setCus_email(String cus_email) {
	this.cus_email = cus_email;
}

public int getCus_status() {
	return cus_status;
}

public void setCus_status(int cus_status) {
	this.cus_status = cus_status;
}

public int getEmployee_eid() {
	return employee_eid;
}

public void setEmployee_eid(int employee_eid) {
	this.employee_eid = employee_eid;
}




















}
