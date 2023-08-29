package com.batch8grp1.obs.payload.response;

public class WithdrawResponse {
	
	public String getWithdrawid() {
		return withdrawid;
	}

	public void setWithdrawid(String withdrawid) {
		this.withdrawid = withdrawid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	String withdrawid;
	long amount;
	String msg;
	
	public WithdrawResponse() {}
	
	public WithdrawResponse(String withdrawid, long amount, String msg) {
		super();
		this.withdrawid = withdrawid;
		this.amount = amount;
		this.msg = msg;
	}

	
	
}
