package com.example.eicucuy.controller.thread;

public class Task1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始");
        while (true) {

        }
    }
}
