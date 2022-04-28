package ru.yandex.practicum.catsgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.models.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> getAll() {
        logger.debug("Текущее количество пользователей: {}", userService.getAll().size());
        return userService.getAll();
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping("/user/{userMail}")
    public User getUser(@PathVariable("userMail") String userMail){
        return userService.findUserByEmail(userMail);
    }

}
