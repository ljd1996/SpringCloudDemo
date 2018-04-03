package com.hearing.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by hearing on 18-2-26
 */

@RestController
@Configuration
public class DemoController {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    //	@GetMapping("/hello")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @GetMapping("/demo")
    public String demo() {
        return restTemplate().getForEntity("http://HELLO-SERVICE/demo", String.class).getBody();
    }
}
