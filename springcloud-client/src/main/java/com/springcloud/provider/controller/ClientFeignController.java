package com.springcloud.provider.controller;

import com.springcloud.provider.service.ServerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ClientFeignController
 * @Description TODO
 * @Author boy
 * @Date 2021/10/16 10:42 AM
 */
@RestController
public class ClientFeignController {

    @Autowired
    private ServerApi serverApi;

    @RequestMapping("/helloClient4")
    public String helloClient(){
        return serverApi.helloServer();
    }
}
