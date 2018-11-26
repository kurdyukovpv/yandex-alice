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
        return makeResponse(body);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> makeResponse(HashMap<String, Object> body) {
        Map<String, Object> result = new HashMap<>();
        result.put("session", body.get("session"));
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> request = (Map<String, Object>) body.get("request");
        var answer = getAnswer((String) request.get("command"));
        response.put("text", answer);
        response.put("tts", answer);
        response.put("end_session", answer.equals("Пока!"));
        result.put("response", response);
        result.put("version", "1.0");
        return result;
    }

    private String getAnswer(String command) {
        if (command.toLowerCase().contains("как дела")) {
            return "Всё хорошо";
        } else if (command.toLowerCase().contains("пока")) {
            return "Нет нет и еще раз нет!";
        } else if (command.toLowerCase().contains("стоп")) {
            return "Пока!";
        } else {
            return "Не понял!";
        }
    }
}
