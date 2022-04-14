package ru.yandex.practicum.catsgram.controllers;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.models.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final HashMap<String, User> users = new HashMap<>();

    @GetMapping
    public HashMap<String, User> getAll() {
        return users;
    }

    @PostMapping
    public void create(@RequestBody User user) {
        try {
            if (user.getEmail() == null || user.getEmail().equals("")) {
                throw new InvalidEmailException("Введите e-mail");
            }
            if (users.containsKey(user.getEmail())) {
                throw new UserAlreadyExistException("Пользователь с таким e-mail уже существует");
            }
            users.put(user.getEmail(), user);
        } catch (InvalidEmailException | UserAlreadyExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @PutMapping
    public void update(@RequestBody User user) {
        try {
            if (user.getEmail() == null || user.getEmail().equals("")) {
                throw new InvalidEmailException("Введите e-mail");
            }
            users.put(user.getEmail(), user);
        } catch (InvalidEmailException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
