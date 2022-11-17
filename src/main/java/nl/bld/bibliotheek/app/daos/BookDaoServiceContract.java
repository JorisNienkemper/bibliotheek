package nl.bld.bibliotheek.app.daos;


import nl.bld.bibliotheek.app.domain.Book;

import java.util.List;

public interface BookDaoServiceContract {

    void save(Book book);

    void update(Book book);

    void remove(Book book);

    Book getBookById(Long id);

    List<Book> getBooksByBookTitle(String title);

    List<Book> getBooksByAuthorName(String authorName);
}