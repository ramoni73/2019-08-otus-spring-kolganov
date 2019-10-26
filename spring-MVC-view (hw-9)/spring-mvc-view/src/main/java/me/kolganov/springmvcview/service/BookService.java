package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    String getById(long id);
    void save(Book book, long authorId, long genreId);
    void save(Book book);
    void delete(long id);
}
