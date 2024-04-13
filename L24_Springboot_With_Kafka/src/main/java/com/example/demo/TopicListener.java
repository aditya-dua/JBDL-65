package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {
	
	private String topic = "hello-world";
	
	@Autowired
	EmailSenderService emailService;
	
	@KafkaListener(topics="hello-world",groupId="group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		
		
		System.out.println("payload"+payload);
		
		System.out.println("Topic:"+payload.topic());
		System.out.println("Key:"+payload.key());
		System.out.println("Value:"+payload.value());
		
		// Send Email
		
		emailService.sendMail("adityadua1992@gmail.com", "Kafka Message Recieved ", "Kafka Message Recieved "+payload.value());
		System.out.println("Mail Sent");
		// Insert into new DB
	}

}
