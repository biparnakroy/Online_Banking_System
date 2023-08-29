package com.batch8grp1.obs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.payload.response.RegisterResponse;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class NetbankingServiceImpl implements NetbankingService {

	@Autowired private NetbankingRepository netbankingRepository;
	@Autowired private UserDetailsRepository userDetailsRepository;

	
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public RegisterResponse register(NetbankingDto netbankingDto) {
//		Netbanking netbanking=new Netbanking(netbankingDto.getNetbankingId(),
//				netbankingDto.getAccountId(),netbankingDto.getPassword(),netbankingDto.getTxnPassword(),netbankingDto.getOtp());
		
		Netbanking netbanking = netbankingRepository.findByAccountId(netbankingDto.getAccountId());
		
		if(netbanking==null)
		{
			return new RegisterResponse(null,"Account doesn't exists");
		}
		
		netbanking.setPassword(netbankingDto.getPassword());
		netbanking.setTxnPassword(netbankingDto.getTxnPassword());
		netbanking.setOtp(netbankingDto.getOtp());
		netbankingRepository.save(netbanking);
		
		return new RegisterResponse(netbanking.getNetbankingId(),"Netbanking Registration Successful!");
	}

	NetbankingDto netbankingDto;
	@SuppressWarnings("unused")
	@Override
	public LoginMessage loginNetbanking(LoginDto loginDto) {
		
		if(loginDto.getNetbankingId().equals("admin") && loginDto.getPassword().equals("adminpassword"))
		{
			return new LoginMessage("4573689932","Mr","Admin","Admin","Login Successful",true);
		}
		Netbanking netbanking1 = netbankingRepository.findByNetbankingId(loginDto.getNetbankingId());
		if(netbanking1 != null)
		{
			String password = loginDto.getPassword();
			String encodedPassword = netbanking1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			
			if(isPwdRight) {
				
				UserDetails user=userDetailsRepository.findByAccountId(netbanking1.getAccountId());

				return new LoginMessage(netbanking1.getNetbankingId(),user.getTitle(),user.getFirstName(),user.getLastname(),"Login Successful",false);}
			else {
				return new LoginMessage(netbanking1.getNetbankingId(),"","","","Login Failed",false);}
				
//				Netbanking netbanking2=netbankingRepository.findByNetbankingIdAndPassword(loginDto.getNetbankingId(), encodedPassword);
//				UserDetails user=userDetailsRepository.findByAccountId(netbanking2.getAccountId());
//				if(netbanking2 != null) {
//					return new LoginMessage(netbanking2.getNetbankingId(),user.getTitle(),user.getFirstName(),user.getLastname(),"Login Successful");
//				}else {
//					return new LoginMessage(netbanking2.getNetbankingId(),"","","","Login Failed");}
				
			}else {
				return new LoginMessage("","","","","User's Netbanking doesn't exists",false);
			}
//	}
		//return new LoginMessage("","","","","User doesn't exists");
	}
	
	

	

}
