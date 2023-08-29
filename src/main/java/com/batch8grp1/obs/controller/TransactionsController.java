package com.batch8grp1.obs.controller;

import java.time.LocalDate;
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

import com.batch8grp1.obs.dto.TransferRequestDto;
import com.batch8grp1.obs.dto.WithdrawDto;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.TransferResponse;
import com.batch8grp1.obs.payload.response.WithdrawResponse;
import com.batch8grp1.obs.service.TransactionsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/transactions")
public class TransactionsController {
	
	@Autowired private TransactionsService txnService;
	
//	@GetMapping("/alltxns")
//	public ResponseEntity<?> allTxns()
//	{
//		List<Transactions> alltxns = txnService.getAllTransactions();
//		if(alltxns.isEmpty())
//		{
//			throw new CustomException("No transactions to Display");
//		}
//		else return ResponseEntity.ok(alltxns);
//	}

	@GetMapping("/byaccountid")
	public ResponseEntity<?> txnByAccountId(@RequestParam String accountId)
	{
		List<Transactions> usertxn = txnService.getTxnByAccountId(accountId);
		if(usertxn.isEmpty())
		{
			throw new CustomException("No transactions by the User to Display");
		}
		else return ResponseEntity.ok(usertxn);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> txnOfUser(@RequestParam String netbankingId)
	{
		List<Transactions> usertxn = txnService.getTxnOfFromUserId(netbankingId);
		if(usertxn.isEmpty())
		{
			throw new CustomException("No transactions by the User to Display");
		}
		else return ResponseEntity.ok(usertxn);
	}
	
	@GetMapping("/gettxn")
	public ResponseEntity<?> getTxn(@RequestParam String transactionId)
	{
		Transactions txn = txnService.getTxn(transactionId);
		if(txn == null)
		{
			throw new CustomException("No such transaction exists");
		}
		else return ResponseEntity.ok(txn);
	}

	@GetMapping("/txnoftype")
	public ResponseEntity<?> txnOfType(@RequestParam String transactionType)
	{
		List<Transactions> txnoftype = txnService.getTxnOfType(transactionType);
		if(txnoftype.isEmpty())
		{
			throw new CustomException("No transactions of the selected type");
		}
		else return ResponseEntity.ok(txnoftype);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<?> txn(@RequestBody TransferRequestDto transferRequestDto)
	{
		TransferResponse transfer = txnService.transfer(transferRequestDto);
		if(transfer.getMsg()!="Tranaction Successful!")
		{
			throw new CustomException("Something Went Wrong!");
		}
		else return ResponseEntity.ok(transfer);
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<?> withdrawRequest(@RequestBody WithdrawDto withdrawldto)
	{
		WithdrawResponse response = txnService.withdrawalRequest(withdrawldto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getbalance")
	public ResponseEntity<?> getBalance(@RequestParam String netbankingId)
	{
		long response = txnService.getBalance(netbankingId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getusertxns")
	public ResponseEntity<?> getTxnFromToDate(@RequestParam String netbankingId, @RequestParam LocalDate startdate, @RequestParam LocalDate enddate)
	{
		List<Transactions> response = txnService.getTxnFromToDate(netbankingId,startdate, enddate);
		return ResponseEntity.ok(response);
	}
	
}
