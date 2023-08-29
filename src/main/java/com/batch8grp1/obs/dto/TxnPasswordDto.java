package com.batch8grp1.obs.dto;

public class TxnPasswordDto {
	
	private String accountId;
	private String newTxnPassword;
	private String confirmTxnPassword;
	
	public TxnPasswordDto() {
		super();
	}

	public TxnPasswordDto(String accountId, String newTxnPassword, String confirmTxnPassword) {
		super();
		this.accountId = accountId;
		this.newTxnPassword = newTxnPassword;
		this.confirmTxnPassword = confirmTxnPassword;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getNewTxnPassword() {
		return newTxnPassword;
	}

	public void setNewTxnPassword(String newTxnPassword) {
		this.newTxnPassword = newTxnPassword;
	}

	public String getConfirmTxnPassword() {
		return confirmTxnPassword;
	}

	public void setConfirmTxnPassword(String confirmTxnPassword) {
		this.confirmTxnPassword = confirmTxnPassword;
	}

	
	

}
