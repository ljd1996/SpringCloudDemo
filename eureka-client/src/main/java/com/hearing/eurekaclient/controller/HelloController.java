package com.hearing.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by hearing on 18-1-29
 */

@RestController
public class HelloController {

    @Autowired
    private Registration registration;       // 服务注册

    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance instance = serviceInstance();
        return "provider service, host = " + instance.getHost()
                + ", service_id = " + instance.getServiceId();
    }

    @GetMapping("/demo")
    public String demo() {
        return "Demo";
    }

    /**
     * 获取当前服务的服务实例
     *
     * @return ServiceInstance
     */
    private ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        //registration.getServiceId()---->provider-service
        System.out.println(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
