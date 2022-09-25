package com.example.eicucuy.controller.thread;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/thread/v1")
public class Test1Controller {

    @Autowired
    private ExecutorService executorService;

    @GetMapping("/test")
    public void test() throws InterruptedException {

        //假设这个接口的任务我要执行1000ms
//        int i = 0;
//
//        while (i < 1000) {
//            i++;
//            System.out.println(i);
//        }

        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            int i = 0;
            while (i < 1000) {
                i++;
                System.out.println(i);
            }
            return i;
        }, executorService);
        System.out.println(integerCompletableFuture1.join());



//        while (true) {
//            Thread.sleep(1000);
//            System.out.println("test1中的线程：" + thread.getName());
//        }
    }
}
