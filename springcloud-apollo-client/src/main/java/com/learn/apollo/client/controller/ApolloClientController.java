package com.learn.apollo.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panlf
 * @date 2019/12/20
 */
@RestController
public class ApolloClientController {

    @Value("${apollo.client.name}")
    private String clientName;

    @GetMapping("/getname")
    public String getClientName(){
        return clientName;
    }
}
