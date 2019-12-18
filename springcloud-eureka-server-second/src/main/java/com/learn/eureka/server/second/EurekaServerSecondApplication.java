package com.learn.eureka.server.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSecondApplication.class,args);
    }
}
