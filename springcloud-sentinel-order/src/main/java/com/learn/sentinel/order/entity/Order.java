package com.learn.sentinel.order.entity;

import com.learn.sentinel.product.entity.Product;
import lombok.Data;

/**
 * @author Panlf
 * @date 2019/12/17
 */
@Data
public class Order {
    private Integer id;
    private String address;
    private Product product;
}
