package ru.yandex.practicum.catsgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private final static Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/home")
    public String homePage() {
        logger.info("Запрос получен.");
        return "Котограм";
    }
}
