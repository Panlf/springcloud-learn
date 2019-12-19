package com.learn.sentinel.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.learn.sentinel.order.entity.Order;
import com.learn.sentinel.order.feign.ProductFeignClient;
import com.learn.sentinel.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author Panlf
 * @date 2019/12/19
 */
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @SentinelResource
     *  blockHandler 声明熔断时调用的降级方法
     *  fallback 抛出异常执行的降级方法
     * @param id
     * @return
     */
    @SentinelResource(blockHandler = "orderBlockHandler",fallback = "orderFallBack")
    @GetMapping("get/{id}")
    public Order findById(@PathVariable Integer id) {
        /**
         * 用于测试熔断器
         */
        if(id==1){
            throw new RuntimeException("id等于1人为异常");
        }
        Product product =restTemplate.getForObject("http://sentinel-product/get/"+id, Product.class);
        Order order = new Order();
        order.setId(id);
        order.setAddress("杭州");
        order.setProduct(product);
        return order;
    }

    /**
     * 定义降级逻辑
     * @param id
     * @return
     */
    public Order orderBlockHandler(@PathVariable Integer id) {
        Product product = new Product();
        product.setName("触发熔断的降级方法");
        Order order = new Order();
        order.setId(id);
        order.setProduct(product);
        return order;
    }

    public Order orderFallBack(@PathVariable Integer id) {
        Product product = new Product();
        product.setName("抛出异常执行的降级方法");
        Order order = new Order();
        order.setId(id);
        order.setProduct(product);
        return order;
    }



    @Autowired
    private ProductFeignClient productFeignClient;

    /**
     * @param id
     * @return
     */
    @GetMapping("feign/{id}")
    public Order findByIdFeign(@PathVariable Integer id){
        Product product =productFeignClient.findById(id);
        Order order = new Order();
        order.setId(id);
        order.setAddress("上海");
        order.setProduct(product);
        return order;
    }

}
