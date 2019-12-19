package com.learn.sentinel.product.controller;


import com.learn.sentinel.product.entity.Product;
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
        if(id==2){
            try{
                TimeUnit.MILLISECONDS.sleep(2000);
            }catch (Exception e){}
        }
        Product product = new Product();
        product.setId(id);
        product.setName(id+" -- test sentinel Product");
        product.setPrice(id*28.5);
        return product;
    }
}
