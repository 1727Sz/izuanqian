/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sanlion
 */
public class Filter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }
    
    @Autowired private TokenManager tokenManager;

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        tokenManager.hand(ctx.getRequest());
        return "dlajdlkasdjljs";
    }

}
