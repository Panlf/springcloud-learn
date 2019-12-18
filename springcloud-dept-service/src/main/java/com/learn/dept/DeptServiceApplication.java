package com.learn.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceApplication.class,args);
    }
}
