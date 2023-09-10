package ru.yandex.practicum.filmorate.model;


import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class Film {

    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Size(max = 200, message = "Description cannot exceed 200 characters")
    private String description;

    @PastOrPresent(message = "Release date cannot be in the future")
    @NotNull(message = "Release date cannot be null")
    private LocalDate releaseDate;

    @Positive(message = "Duration must be positive")
    private Integer duration;
}
