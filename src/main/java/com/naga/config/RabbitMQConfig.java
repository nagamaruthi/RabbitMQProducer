package com.naga.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	
	public static final String ROUTING_KEY = "TestQueue";
	
	@Bean
	Queue queue() {
		return new Queue(ROUTING_KEY, true);
	}
	
	@Bean
	TopicExchange exchagne() {
		return new TopicExchange("MyExchange");
	}
	
	@Bean
	Binding binding(Queue q, TopicExchange ex) {
		return BindingBuilder.bind(q).to(ex).with(ROUTING_KEY);
	}
	
	
	
}
