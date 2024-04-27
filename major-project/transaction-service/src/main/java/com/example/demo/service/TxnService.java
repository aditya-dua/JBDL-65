package com.example.demo.service;

import org.apache.kafka.common.Uuid;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
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
}
