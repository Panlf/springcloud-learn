package com.learn.sleuth.product.controller;


import com.learn.sleuth.product.entity.Product;
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
        if(id==4){
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        Product product = new Product();
        product.setId(id);
        product.setName(id+" -- sleuth Product");
        product.setPrice(id*29.3);
        return product;
    }
}
