package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;

import ru.yandex.practicum.filmorate.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final List<User> users = new ArrayList<>();
    private int currentId = 1;

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(currentId++);
        users.add(user);
        log.info("User created: {}", user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ValidationException("User not found"));
        existingUser.setEmail(user.getEmail());
        existingUser.setLogin(user.getLogin());
        existingUser.setName(user.getName());
        existingUser.setBirthday(user.getBirthday());
        log.info("User updated: {}", existingUser);
        return existingUser;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}