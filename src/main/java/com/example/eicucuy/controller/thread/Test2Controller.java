package com.example.eicucuy.controller.thread;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/thread/v2")
public class Test2Controller {
    @Autowired
    private ExecutorService executorService;

    @GetMapping("/test")
    public void test() throws InterruptedException {









//        Thread thread = Thread.currentThread();
//        System.out.println("test2中的线程：" + thread.getName());

//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("v2来了");
//            }
//        });

        //2.有返回值异步任务 supplyAsync()
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程号为***" + Thread.currentThread().getId());
            int i = 5;
            System.out.println("---------" + i);
            return i;
        }, executorService).whenComplete((r, e) -> {
//            whenComplete第一个参数是结果，第二个参数是异常，他可以感知异常，无法返回默认数据
            System.out.println("执行完毕，结果是---" + r + "异常是----" + e);
        }).exceptionally(u -> {
//            exceptionally只有一个参数是异常类型，他可以感知异常，同时返回默认数据10
            return 10;
//            handler既可以感知异常，也可以返回默认数据，是whenComplete和exceptionally的结合
        }).handle((r, e) -> {
            if (r != null) {
                return r;
            }
            if (e != null) {
                return 0;
            }
            return 0;
        });
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            return 1;
        }, executorService);

        System.out.println(integerCompletableFuture.join());
        System.out.println("v2");
    }
}
