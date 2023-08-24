package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.TransferRequestDto;
import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.TransferResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.TransactionsRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	@Autowired private TransactionsRepository txnRepository;
	
	@Autowired private AccountDetailsRepository accountDetailsRepository;
	
	@Autowired private NetbankingRepository netbankingRepository;
	
	public List<Transactions> getAllTransactions()
	{
		List<Transactions> allTxns = txnRepository.findAll();
		return allTxns;
	}
	
	public List<Transactions> getTxnOfFromUserId(String netbankingId)
	{

		String accountId = netbankingRepository.findByNetbankingId(netbankingId).getAccountId().toString();
		AccountDetails fromaccount=accountDetailsRepository.findByAccountId(accountId);
		List<Transactions> txnfromuser = txnRepository.findByFromUserId(accountId);
		return txnfromuser;
		
	}
	
	public List<Transactions> getTxnFromToDate(String netbankingId,LocalDate startdate, LocalDate enddate)
	{

		String accountId = netbankingRepository.findByNetbankingId(netbankingId).getAccountId().toString();
		AccountDetails fromaccount=accountDetailsRepository.findByAccountId(accountId);
		List<Transactions> txnfromuser = txnRepository.findByFromUserId(accountId);
		List<Transactions> txnfromdate;
		ListIterator<Transactions> itr = txnfromuser.listIterator();
//		for(Transactions t : txnfromuser)
//		{
//			if(t.CompletedAt().isBefore(enddate) && )
//		}
		return txnfromuser;
		
	}
	
	public Transactions getTxn(String transactionId)
	{
		Transactions txn = txnRepository.findByTransactionId(transactionId);
		return txn;
	}

	public List<Transactions> getTxnOfType(String transactionType)
	{
		
		List<Transactions> txntype = txnRepository.findByTxnType(transactionType);
		return txntype;
		
	}
	
	public TransferResponse transfer(TransferRequestDto transferRequestDto)
	{
		String accountId = netbankingRepository.findByNetbankingId(transferRequestDto.getFromUserId()).getAccountId();
		AccountDetails fromaccount=accountDetailsRepository.findByAccountId(accountId);
		
		if(fromaccount.getBalance() < transferRequestDto.getAmount())
		{
			return new TransferResponse(new Transactions(),"Insufficient Balance to complete this transactions");
		}
		else {
			
			Transactions txn = new Transactions(transferRequestDto.getTxnType(),LocalDate.now().toString(),LocalDate.now().toString(),accountId,transferRequestDto.getToUserId(),transferRequestDto.getAmount(),transferRequestDto.getRemarks(),false);
			//txn.setBalance(txn.getBalance()-amount);
			AccountDetails toaccount =  accountDetailsRepository.findByAccountId(transferRequestDto.getToUserId());
			
			fromaccount.setBalance(fromaccount.getBalance()-transferRequestDto.getAmount());
			toaccount.setBalance(toaccount.getBalance()+transferRequestDto.getAmount());
			
			txnRepository.save(txn);
			
			return new TransferResponse(txn,"Transaction Successful!");
		}
		
	}
	
	public String withdrawalRequest(String netbankingId, long amount)
	{
		String accountId = netbankingRepository.findByNetbankingId(netbankingId).getAccountId();
		AccountDetails txn=accountDetailsRepository.findByAccountId(accountId);
		if(txn.getBalance() < amount)
		{
			throw new CustomException("Insufficient balance to proceed with this withdrawl request");
		}
		else {
			txn.setBalance(txn.getBalance()-amount);
			String requestno = generateUniqueNumericString(7);
			return "Withdrawal request raised successfully" + requestno;
		}
	}
	
	public long getBalance(String accountId)
	{
		AccountDetails acc = accountDetailsRepository.findByAccountId(accountId);
		return acc.getBalance();
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
