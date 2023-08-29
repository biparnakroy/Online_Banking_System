package com.batch8grp1.obs.service;

import java.util.List;

import com.batch8grp1.obs.dto.BeneficiaryDto;
import com.batch8grp1.obs.entity.Beneficiary;

public interface BeneficiaryService {

	List<Beneficiary> addBeneficary(BeneficiaryDto beneficiaryDto);
	List<Beneficiary> getBeneficary(String netbankingId);
}
