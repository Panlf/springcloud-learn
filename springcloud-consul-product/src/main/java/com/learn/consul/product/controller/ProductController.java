package com.learn.consul.product.controller;

import com.learn.consul.product.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Panlf
 * @date 2019/12/17
 */
@RestController
public class ProductController {

    @GetMapping("get/{id}")
    public Product findById(@PathVariable Integer id){

        /**
         * 用于测试Hystrix的熔断器的超时时间
         */
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (Exception e){}

        Product product = new Product();
        product.setId(id);
        product.setName(id+" -- test Product");
        product.setPrice(id*29.3);
        return product;
    }
}
