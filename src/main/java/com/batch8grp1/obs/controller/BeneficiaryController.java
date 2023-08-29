package com.batch8grp1.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.dto.BeneficiaryDto;
import com.batch8grp1.obs.entity.Beneficiary;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.service.BeneficiaryService;
import com.batch8grp1.obs.service.TransactionsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired private BeneficiaryService beneficiaryService;

		@GetMapping("/")
		public ResponseEntity<?> allBeneficiary(@RequestParam String netbankingId)
		{
			List<Beneficiary> allbenef = beneficiaryService.getBeneficary(netbankingId);
			if(allbenef.isEmpty())
			{
				throw new CustomException("No beneficiaries to Display");
			}
			else return ResponseEntity.ok(allbenef);
		}
		
		@PostMapping("/add")
		public ResponseEntity<?> addBeneficiary(@RequestBody BeneficiaryDto beneficiaryDto)
		{
			List<Beneficiary> allbenef = beneficiaryService.addBeneficary(beneficiaryDto);
			return ResponseEntity.ok(allbenef);
		}

}
