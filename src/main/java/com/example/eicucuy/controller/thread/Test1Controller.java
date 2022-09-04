package com.example.eicucuy.controller.thread;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread/v1")
public class Test1Controller {

    @GetMapping("/test")
    public void test() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (true) {
            Thread.sleep(1000);
            System.out.println("test1中的线程：" + thread.getName());
        }
    }
}
