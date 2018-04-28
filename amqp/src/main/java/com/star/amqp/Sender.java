package com.star.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate amqpTemplate;

    public void sendMessage(String routingKey, Object message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
