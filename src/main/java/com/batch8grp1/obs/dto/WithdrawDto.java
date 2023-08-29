package com.batch8grp1.obs.dto;

public class WithdrawDto {

	String netbankingId;
	long amount;
	
	public WithdrawDto() {}
	
	public WithdrawDto(String netbankingId, long amount) {
		super();
		this.netbankingId = netbankingId;
		this.amount = amount;
	}
	

	public String getNetbankingId() {
		return netbankingId;
	}

	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
