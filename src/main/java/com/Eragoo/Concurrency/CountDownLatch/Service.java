package com.Eragoo.Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * This code demonstrates Latches in java
 */
public class Service {
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 12;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(nThreads);
        Runnable r = () -> {
            try {
                startLatch.await();//wait until startLatch counter not 0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " do work");
            endLatch.countDown();
        };

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(r, i+" thread");
            thread.start();
        }


        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();//waits until all threads finish their work
        long endTime = System.currentTimeMillis();
        System.out.println("Working time: " + (endTime - startTime));
    }
}
