package com.example.kafkaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class KafkaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAppApplication.class, args);
	}

}
