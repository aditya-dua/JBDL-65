package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L24SpringbootWithKafkaApplication {

	
	@Autowired
	KafkaSender kafkaSender;
	public static void main(String[] args) {
		SpringApplication.run(L24SpringbootWithKafkaApplication.class, args);
	}
	
	@GetMapping("/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);
		
		return "Message has been sent to kafka topic hello-world";
	}
	
	/*
	 * 
	 * .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	 * 
	 * .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties 

.\bin\windows\kafka-server-start.bat .\config\server.properties 

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic hello-world --from-beginning
	 * 
	 * Mac:
	 * 
	 * ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
	 * ./bin/kafka-server-start.sh ./config/server.properties
	 * ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hello-world --from-beginning
	 */
	
	
	/**
	 * 
	 * payloadConsumerRecord(topic = hello-world, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1713016883855, serialized key size = -1, serialized value size = 6, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = aditya)
Topic:hello-world
Key:null
Value:aditya
	 * 
	 */

}
