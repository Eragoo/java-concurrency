package com.Eragoo.Concurrency.Barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierService {
    public static void main(String[] args) throws InterruptedException {
        Runnable ferryBoat = () -> System.out.println("Паром переправил автомобили!");
        CyclicBarrier barrier = new CyclicBarrier(2, ferryBoat);

        for (Integer i = 0; i < 6; i++) {
            new Thread(new Car(i.toString(), barrier)).start();
            Thread.sleep(100);
        }
    }
}
