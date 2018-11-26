package ru.sandbox.yandex.alice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliceController {
    private static final Logger log = LoggerFactory.getLogger(AliceController.class);

    @GetMapping("/hello")
    public String helloGet() {
        return "Hello";
    }

    @GetMapping("/world")
    public String world() {
        return "world";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String body) {
        log.warn(body);
        return "Hello Yandex";
    }
}
