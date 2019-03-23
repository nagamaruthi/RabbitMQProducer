package com.naga.producer;

import java.util.Random;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naga.config.RabbitMQConfig;

@Component
public class MessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message) {
		
//		rabbitTemplatesetCorrelationKey("abcd");
		CorrelationData data=new CorrelationData();
		data.setId("345468");
		Random random=new Random();
//		rabbitTemplate.convertAndSend(RabbitMQConfig.ROUTING_KEY, message);
		MessageProperties properties = new MessageProperties();
		properties.setCorrelationId(Integer.toString(random.nextInt()));
		rabbitTemplate.send(RabbitMQConfig.ROUTING_KEY, new Message(message.getBytes(),properties));
		 System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());
	}
}
