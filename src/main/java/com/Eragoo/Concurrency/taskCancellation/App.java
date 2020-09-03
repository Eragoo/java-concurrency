package com.Eragoo.Concurrency.taskCancellation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            int a = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(a++);
            }
        };

        Future<?> future = executorService.submit(task);
        Thread.sleep(1000);
        future.cancel(true);
        System.out.println("finished");
    }
}
