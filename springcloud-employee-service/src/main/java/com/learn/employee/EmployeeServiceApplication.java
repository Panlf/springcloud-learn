package com.learn.employee;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class,args);
    }

    /**
     * @LoadBalanced Ribbon的负载均衡器
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 使用随机策略替换默认的轮询策略
     * @return
     */
    @Bean
    public IRule randomRule(){
        //com.netflix.loadbalancer.RoundRobinRule	以轮询的方式进行负载均衡
        //com.netflix.loadbalancer.RandomRule	随机策略
        //com.netflix.loadbalancer.RetryRule	重试策略
        //com.netflix.loadbalancer.WeightedResponseTimeRule	权重策略.会计算每个服务的权重，越高的被调用的可能性越大
        //com.netflix.loadbalancer.BestAvailableRule	最佳策略.遍历所有服务实例.过滤掉故障实例，并返回请求数最小的实例返回
        //com.netflix.loadbalancer.AvailabilityFilteringRule	可用过滤策略.过滤掉故障和请求数超过阈值的服务实例，再从剩下的实例中轮询调用.
        return new RandomRule();
    }
}
