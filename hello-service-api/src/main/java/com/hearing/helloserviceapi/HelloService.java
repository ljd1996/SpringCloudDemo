package com.hearing.helloserviceapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by hearing on 18-1-30
 */

@RestController
public interface HelloService {
    @GetMapping("/hello")
    String hello();
}
