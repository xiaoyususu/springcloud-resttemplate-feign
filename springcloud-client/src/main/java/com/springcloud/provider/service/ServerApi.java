package com.springcloud.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello-server")
public interface ServerApi {

    @RequestMapping("/helloServer")
    String helloServer();
}
