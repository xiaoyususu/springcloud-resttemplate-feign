package com.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/helloClient")
    public String hello(){
        return "hello-client";
    }

    @RequestMapping("/helloClient1")
    public String helloClient1(){
        String result = template.getForObject("http://127.0.0.1:8001/helloServer", String.class);
        return result;
    }

    @RequestMapping("/helloClient2")
    public Object helloClient2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("hello-server");
        String url = String.format("http://%s:%s/helloServer", serviceInstance.getHost(), serviceInstance.getPort());
        String result = template.getForObject(url, String.class);
        return result;
    }

    @RequestMapping("/helloClient3")
    public Object helloClient3() {
        String url = String.format("http://%s/helloServer", "hello-server");
        String result = template.getForObject(url, String.class);
        return result;
    }
}
