package com.learn.employee.controller;

import com.learn.dept.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@RestController
public class EmployeeController {

    /**
     * SpringCloud自带的获取服务元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用服务名进行调用
     * @param id
     * @return
     */
    @GetMapping(value="get/{id}")
    public Dept findDeptById(@PathVariable Integer id){

        Dept dept = restTemplate.getForObject("http://dept-service/dept/get/"+id,Dept.class);

        return dept;
    }


    /*@GetMapping(value="get/{id}")
    public Dept findDeptById(@PathVariable Integer id){
        List<ServiceInstance> instanceList= discoveryClient.getInstances("dept-service");

        ServiceInstance serviceInstance = instanceList.get(0);

        Dept dept = restTemplate.getForObject("http://"+serviceInstance.getHost()+
                ":"+serviceInstance.getPort()+"/dept/get/"+id,Dept.class);

        return dept;
    }*/
}
