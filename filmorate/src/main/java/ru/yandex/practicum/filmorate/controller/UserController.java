package ru.yandex.practicum.filmorate.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<Film> films = new ArrayList<>();

    @GetMapping("/films")
    public String homePage() {

        return films;
    }
}
