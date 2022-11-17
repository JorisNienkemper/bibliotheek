package nl.bld.bibliotheek.app.testDao;

import nl.bld.bibliotheek.app.daos.BookDaoServiceContract;
import nl.bld.bibliotheek.app.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class dummyBookDAoService implements BookDaoServiceContract {

    @Override
    public void save(Book book) {
        // persist new made book

    }

    @Override
    public void update(Book book) {
// parameter = updated book. persist updated book in this method
    }

    @Override
    public void remove(Book book) {
        // remove from where?
    }

    @Override
    public Book getBookById(Long id) {
        Book book = new Book ("Titel", "Jan", 2);
        return book;
    }

    @Override
    public List<Book> getBooksByBookTitle(String Title) {
        List<Book> books = new ArrayList<>();
        books.add(new Book ("Titel", "Jan", 2));
        books.add(new Book ("Titel2", "Peter", 2));
        return books;
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName) {
        List<Book> books = new ArrayList<>();
        books.add(new Book ("Titel", "Jan", 2));
        books.add(new Book ("Titel2", "Peter", 2));
        return books;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book ("Titel", "Jan", 2));
        books.add(new Book ("Titel2", "Peter", 2));
        return books;
    }
}
