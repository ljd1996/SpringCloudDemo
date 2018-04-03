package com.hearing.feignconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by hearing on 18-1-30
 */

//@Component
public class HelloServiceFallBack implements HelloService{
    @Override
    public String hello() {
        return "error!";
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello() {
//        return "error!";
//    }
}
