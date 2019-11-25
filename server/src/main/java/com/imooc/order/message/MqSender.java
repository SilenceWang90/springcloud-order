package com.imooc.order.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/mqSender")
public class MqSender {
    /*@Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sendMqMessage")
    public String sendMqMessage() {
        amqpTemplate.convertAndSend("myQueue", new Date());
        return "ok";
    }*/
}
