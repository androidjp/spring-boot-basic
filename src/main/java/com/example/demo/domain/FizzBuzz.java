package com.example.demo.domain;

public class FizzBuzz {
  private static final String FIZZ = "FIZZ";
  private static final String BUZZ = "BUZZ";

  public static String say(int num) {
    String res = num + "";

    if (num % 15 == 0) {
      return FIZZ + BUZZ;
    }

    if (num % 3 == 0) {
      res = FIZZ;
    }
    if (num % 5 == 0) {
      res = BUZZ;
    }

    return res;
  }
}
