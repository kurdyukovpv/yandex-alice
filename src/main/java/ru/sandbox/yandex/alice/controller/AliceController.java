package ru.sandbox.yandex.alice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliceController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
