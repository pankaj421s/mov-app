package com.example.kafkaapp.services;



import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSender {
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	String kafkaTopic="mytopic";
	public void send(String message) throws InterruptedException, ExecutionException
	{
		//System.out.println(kafkaTemplate.getProducerFactory().);
		
		kafkaTemplate.send(kafkaTopic,message).addCallback(new ListenableFutureCallback<SendResult<String,String>>()
		{

			@Override
			public void onSuccess(SendResult<String, String> result) {
				// TODO Auto-generated method stub
				logger.debug("message sent");
			}

			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				logger.debug("Not able to send message");
			}
			
		});
		//future.addCallback();
	//	future.get();
	}
	

}
