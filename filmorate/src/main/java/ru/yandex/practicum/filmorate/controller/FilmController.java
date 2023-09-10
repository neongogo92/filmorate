package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {

    private final List<Film> films = new ArrayList<>();
    private int currentId = 1;

    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        film.setId(currentId++);
        films.add(film);
        log.info("Film added: {}", film);
        return film;
    }

    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable int id, @RequestBody Film film) {
        Film existingFilm = films.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ValidationException("Film not found"));
        existingFilm.setName(film.getName());
        existingFilm.setDescription(film.getDescription());
        existingFilm.setReleaseDate(film.getReleaseDate());
        existingFilm.setDuration(film.getDuration());
        log.info("Film updated: {}", existingFilm);
        return existingFilm;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return films;
    }
}