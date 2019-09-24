package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO dao;

    public BookServiceImpl(BookDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        List<Book> books = dao.findAll();

        StringBuilder stringBuilder = new StringBuilder();

        for (Book b : books) {
            stringBuilder.append(b.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void create(Book book) {
        dao.create(book);
    }

    @Override
    public void updateName(Book book) {
        dao.updateName(book);
    }

    @Override
    public void updateAuthor(Book book) {
        dao.updateAuthor(book);
    }

    @Override
    public void updateGenre(Book book) {
        dao.updateGenre(book);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
