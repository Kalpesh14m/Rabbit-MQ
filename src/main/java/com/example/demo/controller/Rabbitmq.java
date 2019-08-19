package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.rabbitservice.Producer;
import com.example.demo.model.Mail;
import com.example.demo.utility.SendEmail;

@RestController
public class Rabbitmq {

	@Autowired
	Producer producer;
	@Autowired
	SendEmail sendmail;
	@Value(value = "spring.mail.username")
	private String mailid;

	@PostMapping(value = "/sendstring")
	public String sendString(@RequestParam String data) {
		Mail mail = new Mail();
		mail.setTo("ToEmailId");
		mail.setFrom(mailid);
		mail.setSubject("hello");
		mail.setContext("hi");
		producer.sendToQueue(mail);
		return "";
	}

}
