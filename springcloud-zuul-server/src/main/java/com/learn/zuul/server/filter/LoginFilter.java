package com.learn.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Panlf
 * @date 2019/12/19
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 定义过滤器类型
     * pre
     * routing
     * post
     * error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     *  返回值越小，执行顺序越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 当前过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行过滤器的业务逻辑
     *  身份认证
     *      1、所有的请求需要携带一个参数 token
     *      2、获取request请求
     *      3、通过request获取参数
     *      4、通过request获取参数token
     *      5、判断oken是否为空 - null 执行失败 !null执行成功
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String token =httpServletRequest.getParameter("token");
        if(token==null){
            //拦截请求
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        //继续执行
        return null;
    }
}
