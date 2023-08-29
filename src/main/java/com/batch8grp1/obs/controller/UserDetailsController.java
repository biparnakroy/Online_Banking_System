package com.batch8grp1.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.TxnPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.CreateAccountResponse;
import com.batch8grp1.obs.service.UserDetailsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired private UserDetailsService userDetailsService;
	
	@PostMapping("/createaccount")
	public ResponseEntity<?> Register(@RequestBody UserDetailsDto userDetailsDto) 
	
	{
		CreateAccountResponse response=userDetailsService.createAccount(userDetailsDto);
		return ResponseEntity.ok(response);
	}
	
	//{accountId} - update it
	@PostMapping("/forgotuserid")
	public ResponseEntity<?> forgotUserId(@RequestParam String AccountId,@RequestParam String otp) 
	
	{
		String response=userDetailsService.forgotUserId(AccountId,otp);
		
		return ResponseEntity.ok(response);
	}
	
	//{accountId} - update it
	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestParam String userId, @RequestParam String otp)
	{
		String response=userDetailsService.forgotPassword(userId,otp);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/setloginpassword")
	public ResponseEntity<?> setLoginPassword(@RequestBody SetLoginPasswordDto setLoginPassword)
	{
		String response=userDetailsService.setLoginPassword(setLoginPassword);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/settxnpassword")
	public ResponseEntity<?> setTxnPassword(@RequestBody TxnPasswordDto TxnPassword)
	{
		String response=userDetailsService.setTxnPassword(TxnPassword);
		
		return ResponseEntity.ok(response);
	}

}
