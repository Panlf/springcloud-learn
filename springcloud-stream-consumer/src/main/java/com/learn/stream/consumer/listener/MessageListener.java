package com.learn.stream.consumer.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author Panlf
 * @date 2019/12/20
 */
@Component
@EnableBinding(Sink.class)
public class MessageListener {

    //监听binding中的消息
    @StreamListener(Sink.INPUT)
    public void input(String message){
        System.out.println("获取消息:"+message);
    }
}
