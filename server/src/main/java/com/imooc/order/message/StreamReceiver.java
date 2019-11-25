package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 消息接收方
 */
/*@Component
@EnableBinding(StreamClient.class)*/
@Slf4j
public class StreamReceiver {
    /*@StreamListener(StreamClient.MyMesageInput)
    @SendTo(StreamClient.MyMesageOutPut)
    public void process(Object object){
        log.info("StreamReceiver is ：{}",object);
    }*/
}
