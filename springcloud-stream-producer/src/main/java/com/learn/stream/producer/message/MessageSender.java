package com.learn.stream.producer.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Panlf
 * @date 2019/12/20
 */
@Component
@EnableBinding(Source.class)
public class MessageSender {
    @Autowired
    private MessageChannel output;

    public void send(Object obj) throws Exception {
        output.send(MessageBuilder.withPayload(obj).build());
    }
}
