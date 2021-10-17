package com.springcloud.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @RequestMapping("/helloServer")
    public String hello(){
        return "hello-server1";
    }
}
