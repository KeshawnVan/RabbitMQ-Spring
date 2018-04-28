package com.star.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskListener.class);

    @Autowired
    private RabbitTemplate amqpTemplate;

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(@Payload SmsDTO message) {

        LOGGER.info(message.toString());

    }
}
