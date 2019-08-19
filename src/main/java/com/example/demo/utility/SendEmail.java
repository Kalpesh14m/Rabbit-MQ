package com.example.demo.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mail;

@Service
public class SendEmail {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(mail.getSubject());
		message.setText(mail.getContext());
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());

		emailSender.send(message);
	}
}
