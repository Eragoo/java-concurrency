package com.Eragoo.Concurrency.Cacher;

import java.math.BigInteger;
import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Computable<BigInteger, BigInteger> c = Fibonacci::count;
        FibonacciCacheService<BigInteger, BigInteger> service = new FibonacciCacheService<>(c);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Введите число: ");
            BigInteger computed = service.compute(BigInteger.valueOf(scanner.nextLong()));
            System.out.println(computed.toString());
        }
    }
}
