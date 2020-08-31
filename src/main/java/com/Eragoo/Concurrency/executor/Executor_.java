package com.Eragoo.Concurrency.executor;

import java.util.concurrent.*;

public class Executor_ {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorCompletionService<String> executor = new ExecutorCompletionService<>(Executors.newFixedThreadPool(3));

        executor.submit(() -> "str 1");
        executor.submit(() -> {
            Thread.sleep(1000);
            return "str 2";
        });
        executor.submit(() -> {
            Thread.sleep(100);
            return "str 3";
        });
        executor.submit(() -> {
            Thread.sleep(2000);
            return "str 4";
        });
        executor.submit(() -> {
            Thread.sleep(3000);
            return "str 5";
        });

        for (int i = 0; i < 6; i++) {
            System.out.println(executor.take().get()); // take() вызывается только если есть какие-то готовые результаты
        }
    }
}
