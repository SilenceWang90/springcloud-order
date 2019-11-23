package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    String MyMesageInput = "myMesageInput";
    String MyMesageOutPut = "myMesageOutPut";
    /**
     * 手动接收消息
     * @return
     */
    @Input(StreamClient.MyMesageInput)
    SubscribableChannel input();

    /**
     * 发送消息
     * @return
     */
    @Output(StreamClient.MyMesageOutPut)
    MessageChannel output();
}
