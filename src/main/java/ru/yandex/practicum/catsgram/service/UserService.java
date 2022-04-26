package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.models.User;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService {

    private final HashMap<String, User> users = new HashMap<>();

    public Collection<User> getAll() {
        return users.values();
    }

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

    public User findUserByEmail (String email) {
        if (users.containsKey(email)) {
            return users.get(email);
        }
        return null;
    }
}
