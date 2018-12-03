package ru.sandbox.yandex.alice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AliceController {

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
        Map<String, Object> session = (Map<String, Object>) body.get("session");
        var answer = "";
        if ((Boolean) session.get("new")) {
            answer = getAnswer("привет");
        } else {
            answer = getAnswer((String) request.get("command"));
        }
        response.put("text", answer);
        response.put("tts", answer);
        response.put("end_session", answer.equals("Пока!"));
        result.put("response", response);
        result.put("version", "1.0");
        return result;
    }

    private String getAnswer(String command) {
        if (command.toLowerCase().contains("привет")) {
            return "Привет!";
        } else if (command.toLowerCase().contains("как дела")) {
            return "Отлично!";
        } else if (command.toLowerCase().contains("пока")) {
            return "Пока!";
        } else if (command.toLowerCase().contains("прод")) {
            return "Запускаю сборку продакшена!";
        } else if (command.toLowerCase().contains("тест")) {
            return "Запускаю сборку тестового стенда!";
        } else {
            return "Не понял!";
        }
    }
}
