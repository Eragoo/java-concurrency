package com.Eragoo.Concurrency.Semaphore;

public class Philosopher extends Thread {
    private Table table;
    private String name;
    private boolean full = false;

    public Philosopher(Table semaphore, String name) {
        this.table = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!full){
                table.acquire();
                System.out.println(name + " садится за стол, собирается есть!");
                Thread.sleep(1);
                full = true;
                System.out.println(name + " наелся и спит! Поэтому покидает стол");
                table.release();
                Thread.sleep(1);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
