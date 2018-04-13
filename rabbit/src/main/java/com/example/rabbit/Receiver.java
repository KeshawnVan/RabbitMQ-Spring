package com.example.rabbit;

import com.rabbitmq.tools.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(@Payload SmsDTO message){
        LOGGER.info(message.toString());
    }
}
