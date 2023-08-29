package com.batch8grp1.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Beneficiary")
public class Beneficiary {
	
	@Id
	
	@Column(name="Beneficiaryid",nullable=false)
	private String id;
	
	
	@Column(name="NetbankingIdofPayee",nullable=false)
	private String netbankingIdofPayee;
	
	@Column(name="Beneficiary_Account_Id",nullable=true)
	private String beneficiaryAccountId;
	
	@Column(name="BeneficiaryName",nullable=true)
	private String beneficiaryName;
	
	public Beneficiary() {
		super();
	}

	public Beneficiary(String netbankingIdofPayee, String beneficiaryAccountId, String beneficiaryName) {
		super();
		this.netbankingIdofPayee = netbankingIdofPayee;
		this.beneficiaryAccountId = beneficiaryAccountId;
		this.beneficiaryName = beneficiaryName;
	}
	
	
	
	public String getNetbankingIdofPayee() {
		return netbankingIdofPayee;
	}



	public void setNetbankingIdofPayee(String netbankingIdofPayee) {
		this.netbankingIdofPayee = netbankingIdofPayee;
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
