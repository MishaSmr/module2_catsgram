package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exceptions.UserNotFoundException;
import ru.yandex.practicum.catsgram.models.Post;
import ru.yandex.practicum.catsgram.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final UserService userService;
    private final List<Post> posts = new ArrayList<>();

    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        try {
            User user = userService.findUserByEmail(post.getAuthor());
            if (user == null) {
                throw new UserNotFoundException("Пользователь " + post.getAuthor() + " не найден.");
            }
            posts.add(post);
            return post;
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
