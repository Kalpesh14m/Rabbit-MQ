package com.example.demo.config.rabbitservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Mail;
import com.example.demo.utility.SendEmail;

@Component
public class Consumer {
//	@Autowired
//	private SendEmail sendmail;
//
//	@RabbitListener(queues = "test-queue")
//	public void receiveString(Mail msg) {
//
//		System.out.println(msg);
//		sendmail.sendSimpleMessage(msg);
//	}
}
