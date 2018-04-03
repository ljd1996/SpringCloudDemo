package com.hearing.zuulgateway.filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest

/**
 * Create by hearing on 18-2-12
 */
class PreFilter extends ZuulFilter {
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 0
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        println('Filter...')
        RequestContext context = RequestContext.getCurrentContext()
        HttpServletRequest request = context.getRequest()
        String token = request.getHeader("token")
        if (token == null) {
            context.setSendZuulResponse(false)
            context.setResponseStatusCode(401)
            return null
        }
        return null
    }
}
