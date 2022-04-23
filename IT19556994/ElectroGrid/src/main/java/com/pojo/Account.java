package com.pojo;

public class Account {
private int accid;
private String serial;
private String install_date;
private String register_date;
private String connection_type;
private String address;
private int status;
private int customer_cid;
private int employee_eid;

public Account() {
	super();
}

public Account(int accid, String serial, String install_date, String register_date, String connection_type,
		String address, int status) {
	super();
	this.accid = accid;
	this.serial = serial;
	this.install_date = install_date;
	this.register_date = register_date;
	this.connection_type = connection_type;
	this.address = address;
	this.status = status;
}



public int getAccid() {
	return accid;
}
public void setAccid(int accid) {
	this.accid = accid;
}
public String getSerial() {
	return serial;
}
public void setSerial(String serial) {
	this.serial = serial;
}
public String getInstall_date() {
	return install_date;
}
public void setInstall_date(String install_date) {
	this.install_date = install_date;
}
public String getRegister_date() {
	return register_date;
}
public void setRegister_date(String register_date) {
	this.register_date = register_date;
}
public String getConnection_type() {
	return connection_type;
}
public void setConnection_type(String connection_type) {
	this.connection_type = connection_type;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

public Account(int accid, String serial, String install_date, String register_date, String connection_type,
		String address, int status, int customer_cid, int employee_eid) {
	super();
	this.accid = accid;
	this.serial = serial;
	this.install_date = install_date;
	this.register_date = register_date;
	this.connection_type = connection_type;
	this.address = address;
	this.status = status;
	this.customer_cid = customer_cid;
	this.employee_eid = employee_eid;
}

public int getCustomer_cid() {
	return customer_cid;
}

public void setCustomer_cid(int customer_cid) {
	this.customer_cid = customer_cid;
}

public int getEmployee_eid() {
	return employee_eid;
}

public void setEmployee_eid(int employee_eid) {
	this.employee_eid = employee_eid;
}



}
