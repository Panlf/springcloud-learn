package com.learn.gateway.server.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Panlf
 * @date 2019/12/20
 */
@Configuration
public class KeyResolverConfiguration {
    /**
     * 编写基于请求路径的限流规则
     * @return
     */
    @Primary
    @Bean
    public KeyResolver pathKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange serverWebExchange) {
                return Mono.just(serverWebExchange.getRequest().getPath().toString());
            }
        };
    }

    @Bean
    public KeyResolver keyResolver(){
        return serverWebExchange -> Mono.just(
                serverWebExchange.getRequest().getQueryParams().getFirst("userID")
                //基于请求IP的限流
                //serverWebExchange.getRequest().getQueryParams().getFirst("X-Forwarded-For")
        );
    }

}
