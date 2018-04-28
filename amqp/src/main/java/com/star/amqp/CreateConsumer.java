package com.star.amqp;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.stream.Stream;

@Component
public class CreateConsumer {

    @Autowired
    private MessageTemplate messageTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void process() {
        Queue queue = new Queue("declare", true);
        rabbitAdmin.declareQueue(queue);
//        new Thread(() -> Stream.generate(() -> amqpTemplate.receiveAndConvert("declare", -1L, ParameterizedTypeReference.forType(SmsDTO.class)))
//                .forEach(it -> System.out.println(it))).start();

        messageTemplate.createListener("declare", System.out::println);
    }
}
