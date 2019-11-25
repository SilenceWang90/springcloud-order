package com.imooc.order.message;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/*@RestController
@RequestMapping("/sendMessage")*/
public class SendMessageController {

    /*@Resource
    private StreamClient streamClient;

    @RequestMapping("/process")
    public void process() {
        String message = "now is：" + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }*/
}
