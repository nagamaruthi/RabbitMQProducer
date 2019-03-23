package com.naga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naga.producer.MessageProducer;

@RestController
public class ProducerController {

	@Autowired
    private MessageProducer messageProducer;

	
	/*
	 * @GetMapping public String produce(@RequestParam String message) {
	 * System.out.print("inside controller"); messageProducer.sendMessage(message);
	 * return "Message Sent to rabbitMQ and message="+message; }
	 */
	
	@RequestMapping("/test")
	public String test(@RequestParam String message) {
//		return "hello from abc-->"+message;
		 messageProducer.sendMessage(message);
		return "Message Sent to rabbitMQ and message="+message;
	}
}
