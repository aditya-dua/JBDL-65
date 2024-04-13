package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {
	
	private String topic = "hello-world";
	
	
	@KafkaListener(topics="hello-world",groupId="group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		
		
		System.out.println("payload"+payload);
		
		System.out.println("Topic:"+payload.topic());
		System.out.println("Key:"+payload.key());
		System.out.println("Value:"+payload.value());
		
		// Insert into new DB
	}

}
