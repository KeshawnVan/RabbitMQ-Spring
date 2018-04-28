package com.star.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @Autowired
    private Sender sender;

    @Autowired
    private MessageTemplate messageTemplate;


    @RequestMapping("message")
    public String getMessage(String message, String key){
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setPhone("123");
        smsDTO.setContent(message);
        messageTemplate.delayConvertAndSend(key, smsDTO, 10000);
        return message;
    }
}
