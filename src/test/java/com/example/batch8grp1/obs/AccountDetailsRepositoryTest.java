package com.example.batch8grp1.obs;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.service.AccountDetailsServiceImpl;;

public class AccountDetailsRepositoryTest{
	@Mock
	private AccountDetailsRepository accountDetailsRepository;
	
	@InjectMocks
	private AccountDetailsServiceImpl accountDetailsService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	 @Test
	    public void testFindByAccountId_Success() {
	        String accountId = "account123";
	        long balance = 1000;
	        String createdAt = "2023-08-25";
	        String isApproved = "Yes";

	        AccountDetails account = new AccountDetails(accountId, balance, createdAt, isApproved);

	        when(accountDetailsRepository.findByAccountId(accountId)).thenReturn(account);

	        AccountDetails retrievedAccount = accountDetailsRepository.findByAccountId(accountId);

	        assertNotNull(retrievedAccount);
	        assertEquals(accountId, retrievedAccount.getAccountId());
	        assertEquals(balance, retrievedAccount.getBalance());
	        assertEquals(createdAt, retrievedAccount.getCreatedAt());
	        assertEquals(isApproved, retrievedAccount.getIsApproved());
	    }

	    @Test
	    public void testFindByAccountId_NotFound() {
	        String accountId = "nonExistentAccount";

	        when(accountDetailsRepository.findByAccountId(accountId)).thenReturn(null);

	        AccountDetails retrievedAccount = accountDetailsRepository.findByAccountId(accountId);

	        assertNull(retrievedAccount);
	    }

	    // Add more test cases for other scenarios
}




	


