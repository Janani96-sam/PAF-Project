package com.pojo;

public class Account {
private int accid;
private String serial;
private String install_date;
private String register_date;
private String connection_type;
private String address;
private String status;

public Account() {
	super();
}

public Account(int accid, String serial, String install_date, String register_date, String connection_type,
		String address, String status) {
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
