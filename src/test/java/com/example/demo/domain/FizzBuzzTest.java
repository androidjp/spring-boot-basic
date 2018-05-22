package com.example.demo.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

  @Test
  public void say() {
    assertTrue("FIZZBUZZ".equals(FizzBuzz.say(0)));
    assertTrue("FIZZBUZZ".equals(FizzBuzz.say(15)));
    assertTrue("FIZZ".equals(FizzBuzz.say(24)));
    assertTrue("BUZZ".equals(FizzBuzz.say(25)));
    assertTrue("4".equals(FizzBuzz.say(4)));
    assertTrue("7".equals(FizzBuzz.say(7)));
  }
}