package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.List;

import com.batch8grp1.obs.dto.TransferRequestDto;
import com.batch8grp1.obs.dto.WithdrawDto;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.payload.response.TransferResponse;
import com.batch8grp1.obs.payload.response.WithdrawResponse;

public interface TransactionsService {
	
	List<Transactions> getAllTransactions();
	List<Transactions> getTxnOfFromUserId(String netbankingId);
	List<Transactions> getTxnByAccountId(String accountId);
	Transactions getTxn(String transactionId);
	List<Transactions> getTxnOfType(String transactionType);
	TransferResponse transfer(TransferRequestDto transferRequestDto);
	WithdrawResponse withdrawalRequest(WithdrawDto withdrawldtop);
	long getBalance(String accountId);
	List<Transactions> getTxnFromToDate(String netbankingId,LocalDate startdate, LocalDate enddate);

}
