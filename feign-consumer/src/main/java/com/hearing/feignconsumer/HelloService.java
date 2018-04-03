package com.hearing.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by hearing on 18-1-30
 */

@FeignClient(name = "hello-service", fallback = HelloServiceFallBack.class)
public interface HelloService{

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
