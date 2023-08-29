package com.batch8grp1.obs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.payload.response.GetAccountResponse;
import com.batch8grp1.obs.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired private AdminService adminService;
	
	@GetMapping("/getallacc")
	public ResponseEntity<?> getAllAcc()
	{
		List<GetAccountResponse> response = adminService.getAllAcc();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getaccforapproval")
	public ResponseEntity<?> getAccforApproval()
	{
		List<AccountDetails> response = adminService.getAllAccforApproval();
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/alltxnsfromdate")
	public ResponseEntity<?> getAllTxnsFromDate(@RequestParam LocalDate startdate,@RequestParam LocalDate enddate )
	{
		List<Transactions> response = adminService.getAllTxnFromToDate(startdate, enddate);
		return ResponseEntity.ok(response);
	}
	

	@PostMapping("/txnsfromdate")
	public ResponseEntity<?> getTxnsFromDate(@RequestParam String netbankingId,@RequestParam LocalDate startdate,@RequestParam LocalDate enddate )
	{
		List<Transactions> response = adminService.getTxnFromToDate(netbankingId,startdate, enddate);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/approval")
	public ResponseEntity<?> approval(@RequestParam String accountId,@RequestParam String isApproved)
	{
		String response = adminService.approved(accountId,isApproved);
		return ResponseEntity.ok(response);
	}
	
}
