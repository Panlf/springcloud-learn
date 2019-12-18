package com.learn.consul.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Panlf
 * @date 2019/12/17
 */
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class ConsulOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication.class,args);
    }


    /**
     * springcloud对console进行了进一步的处理
     * 向其中集成了ribbon的支持
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
