package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	private String exchangeName = "test-exchange";

	private String queueName = "test-queue";

	private String routingKey = "key-routingkey"; 
	
	@Bean
	public Exchange mailExchange() {
		return new DirectExchange(exchangeName);
	}

	/* Creating a bean for the Message queue */
	@Bean
	public Queue mailQueue() {
		return new Queue(queueName);
	}

	@Bean
	public Binding declareBinding(Queue mailQueue, DirectExchange mailExchange) {
		return BindingBuilder.bind(mailQueue).to(mailExchange).with(routingKey);
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
