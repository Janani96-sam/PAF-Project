package com.pojo;

public class Complain {
	private int comid;
	private int account_profiles_accid;
	private String category;
	private String complain;
	private String contact_no;
	private int status;
	private String comment;

	public Complain() {
		super();
	}

	public Complain(int comid, int account_profiles_accid, String category, String complain, String contact_no,
			int status, String comment) {
		super();
		this.comid = comid;
		this.account_profiles_accid = account_profiles_accid;
		this.category = category;
		this.complain = complain;
		this.contact_no = contact_no;
		this.status = status;
		this.comment = comment;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}

	public int getAccount_profiles_accid() {
		return account_profiles_accid;
	}

	public void setAccount_profiles_accid(int account_profiles_accid) {
		this.account_profiles_accid = account_profiles_accid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
