package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.springboot.model.Car;

public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	  @Autowired
	  private KafkaTemplate<String, Car> kafkaTemplate;

	  public void send(Car car) {
	    LOGGER.info("sending car='{}'", car.toString());
	    Message<Car> message = MessageBuilder
                .withPayload(car)
                .setHeader(KafkaHeaders.TOPIC, "topic-car")
                .build();
	    LOGGER.info("message : "+message);
	    kafkaTemplate.send(message);
	  }
}
