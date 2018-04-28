package com.star.amqp;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class MessageTemplate {

    private static final String UTF_8 = "UTF-8";

    @Autowired
    private RabbitTemplate amqpTemplate;

    public void convertAndSend(String routingKey, Object message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }

    public void convertAndSend(String exchange, String routingKey, Object message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void delayConvertAndSend(String routingKey, Object message, Instant time) {
        amqpTemplate.convertAndSend(routingKey, message, (msg) -> {
            if (Instant.now().isBefore(time)) {
                msg.getMessageProperties().setDelay((int) (time.toEpochMilli() - Instant.now().toEpochMilli()));
            }
            return msg;
        });
    }

    public void delayConvertAndSend(String exchange, String routingKey, Object message, Instant time) {
        amqpTemplate.convertAndSend(exchange, routingKey, message, (msg) -> {
            if (Instant.now().isBefore(time)) {
                msg.getMessageProperties().setDelay((int) (time.toEpochMilli() - Instant.now().toEpochMilli()));
            }
            return msg;
        });
    }

    public void delayConvertAndSend(String routingKey, Object message, Integer delay) {
        amqpTemplate.convertAndSend(routingKey, message, (msg) -> {
            msg.getMessageProperties().setHeader("x-delay", delay);
            //msg.getMessageProperties().setDelay(delay);
            return msg;
        });
    }

    public void delayConvertAndSend(String exchange, String routingKey, Object message, Integer delay) {
        amqpTemplate.convertAndSend(exchange, routingKey, message, (msg) -> {
            msg.getMessageProperties().setHeader("x-delay", delay);
            //msg.getMessageProperties().setDelay(delay);
            return msg;
        });
    }

    @SuppressWarnings("unchecked")
    public <T> T receiveAndConvert(String queueName, long timeoutMillis, ParameterizedTypeReference<T> type) {
        return (T) amqpTemplate.receiveAndConvert(queueName, timeoutMillis);
    }

    public void createRabbitListener(String queueName, Function<Channel, com.rabbitmq.client.Consumer> createConsumeFunction) {
        amqpTemplate.execute(channel -> channel.basicConsume(queueName, createConsumeFunction.apply(channel)));
    }

    public void createListener(String queueName, Consumer<String> messageConsumer) {
        amqpTemplate.execute(channel -> channel.basicConsume(queueName, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    String message = new String(body, UTF_8);
                    messageConsumer.accept(message);
                } catch (Exception e) {

                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        }));
    }

    public RabbitTemplate getTemplate() {
        return amqpTemplate;
    }
}
