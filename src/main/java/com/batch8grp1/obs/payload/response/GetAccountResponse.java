package com.batch8grp1.obs.payload.response;

public class GetAccountResponse {
	

	String accountId;
	String createdAt;
	String isApproved;
	String fullName;
	
	public GetAccountResponse(String accountId, String createdAt, String isApproved, String title, String firstName, String lastName) {
		super();
		this.accountId = accountId;
		this.createdAt = createdAt;
		this.isApproved = isApproved;
		this.fullName = title + " " + firstName + " " + lastName;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public String getFullName() {
		return fullName;
	}


}
