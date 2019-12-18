package com.learn.consul.order.feign;

import com.learn.consul.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 声明需要调用的微服务名称
 * @author Panlf
 * @date 2019/12/17
 */
@FeignClient(name="consul-product",fallback = ProductFeignClientCallBack.class)
public interface ProductFeignClient {


    /**
     * 配置需要调用的微服务接口
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public Product findById(@PathVariable("id") Integer id);

}
