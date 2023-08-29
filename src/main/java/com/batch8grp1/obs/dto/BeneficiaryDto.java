package com.batch8grp1.obs.dto;

public class BeneficiaryDto {
	
	private String netbankingIdOfPayee;
	private String beneficiaryAccountId;
	private String beneficiaryName;
	
	
	
	public BeneficiaryDto(String netbankingIdOfPayee, String beneficiaryAccountId, String beneficiaryName) {
		super();
		this.netbankingIdOfPayee = netbankingIdOfPayee;
		this.beneficiaryAccountId = beneficiaryAccountId;
		this.beneficiaryName = beneficiaryName;
	}
	
	public String getNetbankingIdOfPayee() {
		return netbankingIdOfPayee;
	}
	public void setNetbankingIdOfPayee(String netbankingIdOfPayee) {
		this.netbankingIdOfPayee = netbankingIdOfPayee;
	}
	public String getBeneficiaryAccountId() {
		return beneficiaryAccountId;
	}
	public void setBeneficiaryAccountId(String beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

}
