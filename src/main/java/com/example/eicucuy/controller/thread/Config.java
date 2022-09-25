package com.example.eicucuy.controller.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class Config {


    @Bean
    public ExecutorService executorService() {
        //newFixedThreadPool默认的拒绝策略是抛出异常啊 AbortPolicy  为什么实际上是阻塞了呢？ 因为拒绝是当线程池不处理新的提交才拒绝
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // queue是放置阻塞队列的，跟我们的线程池大小的值没有关系
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(65535);
        RejectedExecutionHandler rejectedExecutionHandler = (runnable, executorx) -> {
            try {
                queue.put(runnable);
//                throw new RuntimeException("hahah  拒绝策略");
            } catch (InterruptedException var5) {
                throw new RuntimeException("hahah  拒绝策略");
            }
        };
        int coreSize = Runtime.getRuntime() != null && Runtime.getRuntime().availableProcessors() > 0 ? Runtime.getRuntime().availableProcessors() : 8;
        int maxSize = coreSize * 8;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                coreSize,
                maxSize,
                5l,
                TimeUnit.MILLISECONDS,
                queue);
        return threadPoolExecutor;
    }
}
