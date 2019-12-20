package com.learn.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Panlf
 * @date 2019/12/19
 */
@SpringBootApplication
//开启网关功能
@EnableZuulProxy
public class ZuulServerApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplicaion.class,args);
    }
}
