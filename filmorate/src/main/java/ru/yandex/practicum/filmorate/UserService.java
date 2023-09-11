package ru.yandex.practicum.filmorate;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public User createUser(User user) {
        // Логика создания пользователя
        users.add(user);
        return user;
    }

    public User updateUser(Integer id, User user) {
        // Логика обновления пользователя
        // Найдите пользователя по id и обновите его
        return user;
    }

    public List<User> getAllUsers() {
        // Логика получения всех пользователей
        return users;
    }
}
