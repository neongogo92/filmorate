package ru.yandex.practicum.filmorate.model;

import java.util.Date;
import lombok.Data;

@Data
public class Film {
    int id;
    String name;
    String description;
    Date releaseDate;
    double duration;

}
