package com.learn.consul.order.controller;

import com.learn.consul.order.entity.Order;
import com.learn.consul.order.feign.ProductFeignClient;
import com.learn.consul.product.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 *  DefaultProperties 指定此接口中公共的熔断设置
 *          如果在DefaultProperties指定了公共的降级方法
 *          在@HystrixCommand不需要单独指定了
 * @author Panlf
 * @date 2019/12/17
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get/{id}")
    public Order findById(@PathVariable Integer id) {
        Product product =restTemplate.getForObject("http://consul-product/get/"+id, Product.class);
        Order order = new Order();
        order.setId(id);
        order.setAddress("杭州");
        order.setProduct(product);
        return order;
    }


    @Autowired
    private ProductFeignClient productFeignClient;

    /**
     * 使用注解配置熔断保护
     *  fallbackmethod: 配置熔断之后的降级方法
     * @param id
     * @return
     */
    //@HystrixCommand(fallbackMethod = "orderFallBack")
    @HystrixCommand
    @GetMapping("feign/{id}")
    public Order findByIdFeign(@PathVariable Integer id){
        Product product =productFeignClient.findById(id);
        Order order = new Order();
        order.setId(id);
        order.setAddress("上海");
        order.setProduct(product);
        return order;
    }

    /**
     * 降级方法
     *  返回值与原方法一致
     *  方法参数一致
     * @return
     */
    public Order orderFallBack(@PathVariable Integer id){
        Order order = new Order();
        order.setId(id);
        Product product = new Product();
        product.setName("统一触发降级方法");
        order.setProduct(product);
        return order;
    }

    public Order defaultFallBack(){
        Order order = new Order();
        Product product = new Product();
        product.setName("统一触发降级方法");
        order.setProduct(product);
        return order;
    }
}
