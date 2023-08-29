package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.List;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.payload.response.GetAccountResponse;

public interface AdminService {

	List<GetAccountResponse> getAllAcc();
	List<AccountDetails> getAllAccforApproval();
	List<Transactions> getAllTxnFromToDate(LocalDate startdate, LocalDate enddate);
	List<Transactions> getTxnFromToDate(String netbankingId,LocalDate startdate, LocalDate enddate);
	String approved(String accountId,String isApproved);
	
	
}
