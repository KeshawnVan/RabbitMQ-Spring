package com.star.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

public class RechargeSmsListener {

    @RabbitHandler
    @RabbitListener(queues = SmsGenerateQueues.RECHARGE)
    public void process(@Payload SmsRechargeInfo smsRechargeInfo){
        smsRechargeInfo.setCanOpen(true);
        System.out.println(smsRechargeInfo);
    }
}
