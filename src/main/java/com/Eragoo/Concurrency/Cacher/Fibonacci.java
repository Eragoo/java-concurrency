package com.Eragoo.Concurrency.Cacher;

import java.math.BigInteger;

public class Fibonacci {

    //45
    public static BigInteger count(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return count(n.subtract(BigInteger.TWO)).add(count(n.subtract(BigInteger.ONE)));
    }
}
