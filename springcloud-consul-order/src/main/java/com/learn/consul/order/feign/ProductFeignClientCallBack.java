package com.learn.consul.order.feign;

import com.learn.consul.product.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @author Panlf
 * @date 2019/12/18
 */
@Component
public class ProductFeignClientCallBack implements ProductFeignClient {
    @Override
    public Product findById(Integer id) {
        Product product = new Product();
        product.setName("findById触发降级方法");
        return product;
    }
}
