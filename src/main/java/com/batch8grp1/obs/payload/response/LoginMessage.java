package com.batch8grp1.obs.payload.response;

public class LoginMessage {
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	String netbankingId;
	String fullName;
	String message;
	boolean isAdmin;
	
	public LoginMessage(String netbankingId, String title, String firstName, String lastName, String message,boolean isAdmin) {
		super();
		this.netbankingId = netbankingId;
		this.fullName = title + " " + firstName + " " + lastName;
		this.message = message;
		this.isAdmin=isAdmin;
	}
	public String getNetbankingId() {
		return netbankingId;
	}
	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
