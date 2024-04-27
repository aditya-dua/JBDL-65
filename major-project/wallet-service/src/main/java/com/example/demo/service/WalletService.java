package com.example.demo.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Wallet;
import com.example.demo.repositories.WalletRepository;
import com.example.demo.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WalletService {

	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	JSONParser jsonParser;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${wallet.create.opening-balance}")
	private Double balance;
	
	
	@KafkaListener(topics= {Constants.USER_CREATED_TOPIC}, groupId="group_id")
	public void create(String msg) throws ParseException {
		
		JSONObject event = (JSONObject) jsonParser.parse(msg);
		
		String mobile = String.valueOf(event.get("mobile"));
		
		if(mobile==null) {
			System.out.println("Unable to find the user Id: "+event);
			return ;
		}
		Wallet wallet = Wallet.builder()
				.mobile(mobile)
				.balance(balance)
				.build();
		
		this.walletRepository.save(wallet);
		
	}
	// Hold this
	@KafkaListener(topics= {Constants.TXN_INITIATED_TOPIC}, groupId="group_id")
	public void update(String msg) throws ParseException {
		
		JSONObject event = (JSONObject) jsonParser.parse(msg);
		String sender = String.valueOf(event.get("mobile"));
	}
	
	
}
