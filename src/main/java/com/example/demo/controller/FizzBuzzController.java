package com.example.demo.controller;

import com.example.demo.domain.FizzBuzz;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fizzbuzzgame")
public class FizzBuzzController {

  @RequestMapping(value = "/{num}", method = RequestMethod.GET)
  public String game(@PathVariable int num) {
    return FizzBuzz.say(num);
  }
}
