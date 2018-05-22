package com.star.amqp;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class CreateConsumer {

    @Autowired
    private MessageTemplate messageTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void process() {
        Queue queue = new Queue("declare", true);
        rabbitAdmin.declareQueue(queue);
//        new Thread(() -> Stream.generate(() -> amqpTemplate.receiveAndConvert("declare", -1L, ParameterizedTypeReference.forType(SmsDTO.class)))
//                .forEach(it -> System.out.println(it))).start();

//        messageTemplate.createListener("declare", System.out::println);

        Exchange delay = ExchangeBuilder.directExchange("delay").durable(true).withArgument("x-dead-letter-exchange","delay").build();
        rabbitAdmin.declareExchange(delay);

        Queue delayQueue = QueueBuilder.durable("delay-queue-10")
                .withArgument("x-message-ttl", 10000)
                .withArgument("x-dead-letter-exchange", "delay")
                .withArgument("x-dead-letter-routing-key", "delay-dispatcher")
                .build();
        rabbitAdmin.declareQueue(delayQueue);

        Queue delayQueue20 = QueueBuilder.durable("delay-queue-20")
                .withArgument("x-message-ttl", 20000)
                .withArgument("x-dead-letter-exchange", "delay")
                .withArgument("x-dead-letter-routing-key", "delay-dispatcher")
                .build();
        rabbitAdmin.declareQueue(delayQueue20);

        Queue dispatcher = QueueBuilder.durable("delay-dispatcher").build();
        rabbitAdmin.declareQueue(dispatcher);
        Binding binding = BindingBuilder.bind(dispatcher).to(delay).with("delay-dispatcher").noargs();
        rabbitAdmin.declareBinding(binding);

        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setContent(LocalDateTime.now().toString());
        smsDTO.setPhone("10s");
        rabbitTemplate.convertAndSend("delay-queue-10", smsDTO);

        SmsDTO smsDTO2 = new SmsDTO();
        smsDTO2.setContent(LocalDateTime.now().toString());
        smsDTO2.setPhone("20s");
        rabbitTemplate.convertAndSend("delay-queue-20", smsDTO2);
    }
}
