package com.Eragoo.Concurrency.Cacher;

public interface Computable<A, V>{
    A compute(V arg);
}
