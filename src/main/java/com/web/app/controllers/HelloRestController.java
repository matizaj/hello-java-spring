package com.web.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/greet")
    public Greeting greet(@RequestParam(defaultValue = "Hania") String name) {
        return new Greeting("Hello " + name);
    }
}

record Greeting(String msg) {}
