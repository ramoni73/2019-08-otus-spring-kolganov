package me.kolganov.libraryApp.shell;

import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import me.kolganov.libraryApp.domain.Genre;
import me.kolganov.libraryApp.service.BookService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BookShell {
    private final BookService bookService;

    public BookShell(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public String getAllBooks() {
        return bookService.getAll();
    }

    @ShellMethod(value = "Get book by id", key = {"get-boo-by-id", "gb"})
    public String getBookById(@ShellOption long id) {
        return bookService.getById(id);
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book", "db"})
    public void deleteBookById(@ShellOption long id) {
        bookService.delete(id);
    }

    @ShellMethod(value = "Update book name", key = {"update-book-name", "ubn"})
    public void updateBookName(@ShellOption long id, String name) {
        bookService.updateName(new Book(id, name));
    }

    @ShellMethod(value = "Update book author", key = {"update-book-author", "uba"})
    public void updateBookAuthor(@ShellOption long bookId, long authorId) {
        Book book = new Book();
        book.setId(bookId);
        book.setAuthor(new Author(authorId));

        bookService.updateAuthor(book);
    }

    @ShellMethod(value = "Update book genre", key = {"update-book-genre", "ubg"})
    public void updateBookGenre(@ShellOption long bookId, long genreId) {
        Book book = new Book();
        book.setId(bookId);
        book.setGenre(new Genre(genreId));

        bookService.updateGenre(book);
    }
}