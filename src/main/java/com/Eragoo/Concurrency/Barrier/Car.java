package com.Eragoo.Concurrency.Barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    String name;
    CyclicBarrier barrier;

    public Car(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Автомобиль %s подьехал к переправе\n", name);
            barrier.await();
            System.out.printf("Автомобиль %s поехал дальше\n", name);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
