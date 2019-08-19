package com.example.demo.config.rabbitservice;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Mail;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String exchangeName = "test-exchange";

	private String routingKey = "key-routingkey";
	
	public void sendToQueue(Mail msg) {
		
		amqpTemplate.convertAndSend(exchangeName, routingKey, msg);
		System.out.println("send to queue sucessfully");
	}
}
