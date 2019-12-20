package com.learn.gateway.server.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Panlf
 * @date 2019/12/20
 */
public class LoginFilter implements GlobalFilter,Ordered {
    /**
     * 执行过滤器中的业务逻辑
     * @param serverWebExchange
     * @param gatewayFilterChain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        System.out.println("进入全局过滤器的业务处理");

        String token = serverWebExchange.getRequest().getQueryParams().getFirst("token");

        if(token == null){
            System.out.println("认证失败");
            serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //请求结束
            return serverWebExchange.getResponse().setComplete();
        }
        //认证通过继续执行
        return gatewayFilterChain.filter(serverWebExchange);
    }

    /**
     * 指定过滤器的执行顺序，返回值越小，执行优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
