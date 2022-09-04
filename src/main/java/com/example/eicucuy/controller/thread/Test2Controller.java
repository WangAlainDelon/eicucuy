package com.example.eicucuy.controller.thread;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread/v2")
public class Test2Controller {

    @GetMapping("/test")
    public void test() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("test2中的线程：" + thread.getName());
    }
}
