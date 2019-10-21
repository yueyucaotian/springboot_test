package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/18 17:47
 */
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/test")
    public void test(){
        redisService.set("a12312","12314");
    }
}
