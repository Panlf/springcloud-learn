package com.learn.sentinel.order.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.learn.sentinel.order.entity.Order;
import com.learn.sentinel.product.entity.Product;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author Panlf
 * @date 2019/12/19
 */
public class ExceptionUtils {

    /**
     * 限流熔断降级业务逻辑
     * @param request
     * @param body
     * @param execution
     * @param exception
     * @return
     */
    public static ClientHttpResponse handleFallback(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        System.err.println("Oops:"+exception.getClass().getCanonicalName());
        Product product = new Product();
        product.setName("限流熔断的降级方法");
        Order order = new Order();
        order.setProduct(product);
        return new SentinelClientHttpResponse(JSON.toJSONString(order));
    }

    /**
     * 异常熔断降级业务逻辑
     * @param request
     * @param body
     * @param execution
     * @param exception
     * @return
     */
    public static ClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        System.err.println("Oops:"+exception.getClass().getCanonicalName());
        Product product = new Product();
        product.setName("异常熔断的降级方法");
        Order order = new Order();
        order.setProduct(product);
        return new SentinelClientHttpResponse(JSON.toJSONString(order));
    }
}
