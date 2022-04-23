package com.pojo;

public class Employee {
	private int eid;
	private String ename;
	private String date_of_birth;
	private String emp_nic;
	private String gender;
	private String mobile;
	private String email;
	private String emp_username;
	private String emp_password;
	private int status;
	private int type;

	public Employee() {
		super();
	}

	public Employee(int eid, String ename, String date_of_birth, String emp_nic, String gender, String mobile,
			String email, String emp_username, String emp_password, int status, int type) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.date_of_birth = date_of_birth;
		this.emp_nic = emp_nic;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.status = status;
		this.type = type;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmp_nic() {
		return emp_nic;
	}

	public void setEmp_nic(String emp_nic) {
		this.emp_nic = emp_nic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
