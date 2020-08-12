package com.Eragoo.Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

public class Table extends Semaphore {
    public Table(int places) {
        super(places);
    }
}
