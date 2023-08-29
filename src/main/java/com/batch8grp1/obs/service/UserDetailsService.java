package com.batch8grp1.obs.service;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.TxnPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.payload.response.CreateAccountResponse;

public interface UserDetailsService {

	CreateAccountResponse createAccount(UserDetailsDto userDetailsDto);
	String forgotUserId(String accountId, String otp);
	String forgotPassword(String userId, String otp);
	String setLoginPassword(SetLoginPasswordDto setLoginPassword);
	String setTxnPassword(TxnPasswordDto TxnPasswordDto);
	//String setLoginPassword(String accountId,String newLoginPassword, String confirmLoginPassword);
	//Netbanking loadUserByNetbankingId(String netbankingId) throws UsernameNotFoundException;

}
