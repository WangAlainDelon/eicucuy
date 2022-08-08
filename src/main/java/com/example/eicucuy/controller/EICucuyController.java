package com.example.eicucuy.controller;



import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EICucuyController {

//    @Autowired
//    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public void test(){




    }




}
