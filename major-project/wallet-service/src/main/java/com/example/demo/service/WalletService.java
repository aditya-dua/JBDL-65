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
import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	@KafkaListener(topics= {Constants.TXN_INITIATED_TOPIC}, groupId="group_id")
	public void update(String msg) throws ParseException, JsonProcessingException {
		
		JSONObject event = (JSONObject) jsonParser.parse(msg);
		String sender = String.valueOf(event.get("sender"));
		String receiver = String.valueOf(event.get("receiver"));
		String externalTxnId = String.valueOf(event.get("externalTxnId"));
		Double amount = (Double) event.get("amount");
		
		Wallet senderWallet = this.walletRepository.findByMobile(sender);
		Wallet recieverWallet = this.walletRepository.findByMobile(receiver);
		
		JSONObject message = new JSONObject();
		message.put("receiver", receiver);
		message.put("sender", sender);
		message.put("amount", amount);
		message.put("externalTxnId", externalTxnId);
		
		if(senderWallet == null || recieverWallet == null || senderWallet.getBalance()<amount) {
			System.out.println("Transaction Failed either wallet not found or insufficent baalcne");
			message.put("WalletUpdateStatus", "FAILED");
			kafkaTemplate.send(Constants.WALLET_UPDATE_TOPIC, objectMapper.writeValueAsString(message));
		}
		
		try {
			walletRepository.updateWallet(sender, -amount);
			walletRepository.updateWallet(receiver, amount);
			message.put("WalletUpdateStatus", "SUCCESS");
			kafkaTemplate.send(Constants.WALLET_UPDATE_TOPIC, objectMapper.writeValueAsString(message));
		}catch (Exception e) {
			// TODO: handle exception
			message.put("WalletUpdateStatus", "FAILED");
			kafkaTemplate.send(Constants.WALLET_UPDATE_TOPIC, objectMapper.writeValueAsString(message));
		}
		
		
		
		
	}
	
	
}
