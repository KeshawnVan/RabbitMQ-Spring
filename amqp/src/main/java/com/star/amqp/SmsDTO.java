package com.star.amqp;

import java.io.Serializable;

public class SmsDTO implements Serializable{

    private String phone;

    private String content;

    @Override
    public String toString() {
        return "SmsDTO{" +
                "phone='" + phone + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
