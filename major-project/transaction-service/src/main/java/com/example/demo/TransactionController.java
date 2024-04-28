package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TransactionCreateRequest;
import com.example.demo.models.TxnUser;
import com.example.demo.service.TxnService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class TransactionController {

	@Autowired
	TxnService txnService;
	
	@PostMapping("/transact")
	public String initateTxn(@RequestBody TransactionCreateRequest request) throws JsonProcessingException {
		
		TxnUser user =(TxnUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user);
		return txnService.initate(user.getUsername(), request);
	}
	
}
