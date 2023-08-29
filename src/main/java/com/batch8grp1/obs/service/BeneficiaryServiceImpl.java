package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.BeneficiaryDto;
import com.batch8grp1.obs.entity.Beneficiary;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.repository.BeneficiaryRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired private BeneficiaryRepository beneficiaryRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	
	public List<Beneficiary> addBeneficary(BeneficiaryDto beneficiaryDto)
	{
		Beneficiary newbenef = new Beneficiary(beneficiaryDto.getNetbankingIdOfPayee(),beneficiaryDto.getBeneficiaryAccountId(),beneficiaryDto.getBeneficiaryName());
		beneficiaryRepository.save(newbenef);
		List<Beneficiary> listnew = beneficiaryRepository.findAll();
		ArrayList<Beneficiary> benefofuser = new ArrayList<>();

		for(Beneficiary b : listnew)
		{
			if(b.getNetbankingIdofPayee().equals(beneficiaryDto.getNetbankingIdOfPayee()))
			{
				benefofuser.add(b);
			}
		}
		return listnew;
		
	}
	

	public List<Beneficiary> getBeneficary(String netbankingId)
	{
		List<Beneficiary> listnew = beneficiaryRepository.findAll();
		ArrayList<Beneficiary> benefofuser = new ArrayList<>();

		for(Beneficiary b : listnew)
		{
			if(b.getNetbankingIdofPayee().equals(netbankingId))
			{
				benefofuser.add(b);
			}
		}
		return benefofuser;
		
	}

}
