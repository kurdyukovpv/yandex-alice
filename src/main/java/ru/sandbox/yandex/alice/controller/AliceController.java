package ru.sandbox.yandex.alice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping(value = "/hello")
    public Map<String, Object> helloPost(@RequestBody HashMap<String, Object> body) {
        Map<String, Object> result = new HashMap<>();
        result.put("session", body.get("session"));

        Map<String, Object> response = new HashMap<>();
        response.put("text", "Привет! Это я!");
        response.put("tts", "Привет! Это я!");
        response.put("end_session", false);
        result.put("response", response);
        result.put("version", "1.0");
        return result;
    }
}
