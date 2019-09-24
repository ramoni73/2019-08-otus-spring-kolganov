package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Genre;

public interface GenreService {
    String getAll();
    String getById(long id);
    void create(String name);
    void update(Genre genre);
    void delete(long id);
}
