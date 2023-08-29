package com.batch8grp1.obs.entity;

import java.util.UUID;

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
		this.id=generateUniqueNumericString(7);
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

	public static String generateUniqueNumericString(int length) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().replaceAll("-", ""); 
        String numericString = uuidAsString.replaceAll("[^0-9]", "");
        if (numericString.length() < length) {
            numericString = String.format("%0" + length + "d", Long.parseLong(numericString));
        } else if (numericString.length() > length) {
            numericString = numericString.substring(0, length);
        }

        return numericString;
	}
}
