package com.example.demo.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	SimpleMailMessage simpleMailMessage;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	JSONParser parser;
	
	@KafkaListener(topics="txn_completed",groupId = "group_id")
	public void sendNotification(String msg) throws ParseException {
		
		JSONObject event = (JSONObject) parser.parse(msg);
		String sender = String.valueOf(event.get("sender"));
		String receiver = String.valueOf(event.get("receiver"));
		String externalTxnId = String.valueOf(event.get("externalTxnId"));
		String transactionStatus = String.valueOf(event.get("transactionStatus"));
		Double amount = (Double) event.get("amount");
		
		if(!transactionStatus.equals("FAILED")) {
			String recMsg = "Hi! Your account has been credited with "+amount+"from "+sender;
			
			simpleMailMessage.setTo("adityaduatechm@gmail.com");
			simpleMailMessage.setSubject("Transaction Notification");
			simpleMailMessage.setText(recMsg);
			
			javaMailSender.send(simpleMailMessage);
		}else {
			String recMsg = "Hi! Your transaction of "+amount+"from "+receiver +" has FAILED.";
			
			simpleMailMessage.setTo("adityaduatechm@gmail.com");
			simpleMailMessage.setSubject("Transaction Notification");
			simpleMailMessage.setText(recMsg);
			
			javaMailSender.send(simpleMailMessage);
		}
		
		
		
	}
}
