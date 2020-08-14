package com.Eragoo.Concurrency.Cacher;

import java.math.BigInteger;
import java.util.concurrent.*;

public class FibonacciCacheService<A, V> implements Computable<A, V> {
    private Computable<A, V> counter;
    private ConcurrentHashMap<V, FutureTask<A>> cache;

    public FibonacciCacheService(Computable<A, V> c) {
        this.counter = c;
        cache = new ConcurrentHashMap<>();
    }

    @Override
    public A compute(V arg) {
        while (true) {
            FutureTask<A> futureTask = cache.get(arg);
            if (futureTask == null) {

                futureTask = new FutureTask<>(()->counter.compute(arg));
                Future<A> task = cache.putIfAbsent(arg, futureTask);
                if (task == null) {
                    futureTask.run();
                }
            }
            try {
                return futureTask.get();
            } catch (CancellationException e) {
                cache.remove(arg);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
