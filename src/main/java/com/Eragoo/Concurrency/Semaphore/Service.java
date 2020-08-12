package com.Eragoo.Concurrency.Semaphore;

public class Service {
    public static void main(String[] args) {
        //есть могут не больше двух человек одновременно
        Table table = new Table(2);
        Philosopher socrat = new Philosopher(table, "Socrat");
        Philosopher platon = new Philosopher(table, "Platon");
        Philosopher fales = new Philosopher(table, "Fales");
        Philosopher aristotle =  new Philosopher(table, "Aristotle");

        socrat.start();
        platon.start();
        fales.start();
        aristotle.start();
    }
}
