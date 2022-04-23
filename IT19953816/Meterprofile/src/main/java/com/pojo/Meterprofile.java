package com.pojo;



public class Meterprofile {
	private String id;
	private String name;
	private String connection_type;
	private String estimated_power_consumption;
	private String owner;
	private String initialized_date;
	private String initialized_emp;
	private String location;
	
	public Meterprofile(String id, String name, String connection_type,String estimated_power_consumption, String owner, String initialized_date,
			String initialized_emp, String location) {
		super();
		this.id = id;
		this.name = name;
		this.connection_type = connection_type;
		this.estimated_power_consumption = estimated_power_consumption;
		this.owner = owner;
		this.initialized_date = initialized_date;
		this.initialized_emp = initialized_emp;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConnection_type() {
		return connection_type;
	}
	public void setConnection_type(String connection_type) {
		this.connection_type = connection_type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getInitialized_date() {
		return initialized_date;
	}
	public void setInitialized_date(String initialized_date) {
		this.initialized_date = initialized_date;
	}
	public String getInitialized_emp() {
		return initialized_emp;
	}
	public void setInitialized_emp(String initialized_emp) {
		this.initialized_emp = initialized_emp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEstimated_power_consumption() {
		return estimated_power_consumption;
	}
	public void setEstimated_power_consumption(String estimated_power_consumption) {
		this.estimated_power_consumption = estimated_power_consumption;
	}
}
