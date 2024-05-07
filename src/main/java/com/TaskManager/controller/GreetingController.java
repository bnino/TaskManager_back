package com.TaskManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello from Task Manager";
    }

    @GetMapping("/sayHelloProtected")
    public String sayHelloProtected() {
        return "Hello from Task Manager !Protected";
    }

}
