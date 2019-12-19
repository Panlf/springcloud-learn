package com.learn.sentinel.order;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.learn.sentinel.order.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Panlf
 * @date 2019/12/19
 */

@SpringBootApplication
@EnableFeignClients
public class SentinelOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOrderApplication.class,args);
    }

    /**
     * sentinel 支持对restTemplate的服务调用使用sentinel方法
     *  在构造RestTemplate对象的时候，只需要加载@SentinelRestTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    //@SentinelRestTemplate(fallback = "handleFallback",fallbackClass = ExceptionUtils.class, blockHandler = "handleBlock",blockHandlerClass = ExceptionUtils.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
