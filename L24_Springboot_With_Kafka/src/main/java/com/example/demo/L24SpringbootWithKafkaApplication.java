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
	 * 
	 */

}
