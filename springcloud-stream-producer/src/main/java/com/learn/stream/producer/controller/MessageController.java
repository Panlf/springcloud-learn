package com.learn.stream.producer.controller;

import com.learn.stream.producer.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panlf
 * @date 2019/12/23
 */
@RestController
public class MessageController {

    @Autowired
    private MessageSender messageSender;

    @GetMapping("/send/{message}")
    public String send(@PathVariable String message){
        try{
            messageSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

}
