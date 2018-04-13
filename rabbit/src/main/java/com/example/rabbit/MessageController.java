package com.example.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @Autowired
    private Sender sender;

    @RequestMapping("message")
    public String getMessage(String message){
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setPhone("123");
        smsDTO.setContent(message);
        sender.sendMessage("hello", smsDTO);
        return message;
    }
}
