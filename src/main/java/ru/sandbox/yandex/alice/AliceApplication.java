package ru.sandbox.yandex.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.sandbox")
public class AliceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliceApplication.class, args);
    }
}
