package com.learn.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panlf
 * @date 2019/12/20
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${client.name}")
    private String clientName;

    @GetMapping("/getname")
    public String getClientName(){
        return clientName;
    }
}
