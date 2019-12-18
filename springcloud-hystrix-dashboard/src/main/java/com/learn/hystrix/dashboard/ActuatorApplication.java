package com.learn.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Panlf
 * @date 2019/12/18
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class ActuatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class,args);
    }
}
