package com.izuanqian.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 * Created by root on 17-3-6.
 */
public class SignFilter extends ZuulFilter {

    @Autowired
    private GatewayAuthority gatewayAuthority;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        context.setSendZuulResponse(false);
        if (!gatewayAuthority.isTimeValid(context.getRequest())) {
            context.setResponseStatusCode(HttpStatus.REQUEST_TIMEOUT.value());
            return null;
        }
        if (!gatewayAuthority.isSignValid(context.getRequest())) {
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        return null;
    }
}
