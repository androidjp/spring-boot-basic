package com.example.demo.domain;

public class Fibonacci {

    public static int of(int num) {
        if(num > 2) {
            return of(num - 2) + of(num - 1);
        }
        return 133;
    }
}
