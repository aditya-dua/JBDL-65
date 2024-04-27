package com.example.demo.service;

import org.apache.kafka.common.Uuid;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransactionCreateRequest;
import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionStatus;
import com.example.demo.repo.TxnRepository;
import com.example.demo.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TxnService {

	@Autowired
	TxnRepository txnRepository;
	
	@Autowired
	JSONParser jsonParser;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public String initate(String sender, TransactionCreateRequest request) throws JsonProcessingException {
		
		Transaction transaction = Transaction.builder()
				.externalTxnId(Uuid.randomUuid().toString())
				.sender(sender)
				.reciever(request.getReciever())
				.purpose(request.getPurpose())
				.amount(request.getAmount())
				.transactionStatus(TransactionStatus.PENDING)
				.build();
		
		txnRepository.save(transaction);
		kafkaTemplate.send(Constants.TXN_INITIATED_TOPIC,objectMapper.writeValueAsString(transaction));
		
		return transaction.getExternalTxnId();
	}
	
	@KafkaListener(topics= {Constants.WALLET_UPDATE_TOPIC}, groupId="group_id")
	public void update(String msg) throws ParseException, JsonProcessingException {
		
		JSONObject event = (JSONObject) jsonParser.parse(msg);
		String sender = String.valueOf(event.get("sender"));
		String receiver = String.valueOf(event.get("receiver"));
		String externalTxnId = String.valueOf(event.get("externalTxnId"));
		String WalletUpdateStatus = String.valueOf(event.get("WalletUpdateStatus"));
		Double amount = (Double) event.get("amount");
		
		TransactionStatus transactionStatus = WalletUpdateStatus.equals("FAILED")?TransactionStatus.FAILED:TransactionStatus.SUCCESSFUL;
		this.txnRepository.updateTxnStatus(externalTxnId, transactionStatus);
		
		Transaction transaction = txnRepository.findByExternalTxnId(externalTxnId);
		
		kafkaTemplate.send(Constants.TXN_COMPLETED_TOPIC,objectMapper.writeValueAsString(transaction));
	}
}
