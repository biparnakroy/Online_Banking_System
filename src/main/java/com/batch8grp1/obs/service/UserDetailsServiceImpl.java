package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.CreateAccountResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	@Autowired private AccountDetailsRepository accountDetailsRepository;

	public CreateAccountResponse createAccount(UserDetailsDto userDetailsDto)
	{

		UserDetails newuser=new UserDetails(userDetailsDto.getUserId(),userDetailsDto.getTitle(),userDetailsDto.getFirstName(),userDetailsDto.getLastName(),userDetailsDto.getFatherName(),userDetailsDto.getMobileNo(),userDetailsDto.getEmailId(),
				userDetailsDto.getAadharNo(),userDetailsDto.getdOB(),userDetailsDto.getAddress(),userDetailsDto.getOccupationType(),userDetailsDto.getSourceOfIncome(),userDetailsDto.getGrossAnnualIncome(),userDetailsDto.getAccountId(),false);

		userDetailsRepository.save(newuser);

		Netbanking newnetuser = new Netbanking("",newuser.getAccountId(),"","",null);
		netbankingRepository.save(newnetuser);

		AccountDetails newaccount = new AccountDetails(newuser.getAccountId(),0,LocalDate.now().toString(),null);
		accountDetailsRepository.save(newaccount);

		return new CreateAccountResponse(newuser.getAccountId(),newuser.getTitle(),newuser.getFirstName(),newuser.getLastname());

	}
	//	
	//	public Netbanking loadUserbyUserId(String netbankingId) throws AccountNotFoundException
	//	{
	//		Netbanking user = netbankingRepository.findByNetbankingId(netbankingId);
	//		return new Netbanking(user.getNetbankingId(),user.getPassword(),new ArrayList<>());
	//	}

	@Override
	public String forgotUserId(String accountId, String otp) {
		String response="";
		Netbanking forgotUser=netbankingRepository.findByAccountId(accountId);
		try {
			if(forgotUser != null)
			{
				try {
					if(forgotUser.getOtp().equals(otp))
					{
						response="User Verified.";
					}
				}
				catch(Exception e)
				{
					response = "Wrong Otp";
					throw new CustomException("Wrong Otp");			}
			}
		}catch(Exception e)
		{
			response = "User doesn't exist";
			throw new CustomException("User doesn't exist");
		}

		return response;
	}

	public String forgotPassword(String userId, String otp)
	{
		String response="";
		UserDetails forgotPassword=userDetailsRepository.findByUserId(userId);
		Netbanking user=netbankingRepository.findByAccountId(forgotPassword.getAccountId());
		try {
			if(user != null)
			{
				try {
					if(user.getOtp().equals(otp))
					{
						response="User Verified.";
					}
				}
				catch(Exception e)
				{
					throw new CustomException("Wrong Otp");			}
			}
		}catch(Exception e)
		{
			throw new CustomException("User doesn't exist");
		}

		return response;

	}

	public String setLoginPassword(SetLoginPasswordDto setLoginPasswordDto)
	{
		String response="";
		Netbanking user=netbankingRepository.findByAccountId(setLoginPasswordDto.getAccountId());
		try {
			if(user != null)
			{
				try {
					if(setLoginPasswordDto.getNewLoginPassword().equals(setLoginPasswordDto.getConfirmLoginPassword()))
					{
						user.setPassword(setLoginPasswordDto.getNewLoginPassword());
						netbankingRepository.save(user);
						response ="New Password Set";
					}
				}catch(Exception e)
				{
					throw new CustomException("Couldn't Set New Password");
				}
			}
		}catch(Exception e)
		{
			throw new CustomException("Couldn't Find User");
		}
		return response;

	}

}
