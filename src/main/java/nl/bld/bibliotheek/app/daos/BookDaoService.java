package nl.bld.bibliotheek.app.daos;

import jakarta.persistence.*;
import nl.bld.bibliotheek.app.domain.Book;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BookDaoService implements BookDaoServiceContract{

    private final EntityManagerFactory emf  = Persistence.createEntityManagerFactory("bibliotheek-pu-test");
    private final EntityManager em = emf.createEntityManager();

    public Optional<Book> get(long id) {
        return Optional.ofNullable(em.find(Book.class,id));
    }

    public List<Book> getBooks() {
        Query query = em.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    @Override
    public void save(Book book) {
        executeInsideTransaction(entityManager -> em.persist(book));
    }

    @Override
    public void update(Book book) {
        executeInsideTransaction(EntityManager -> em.merge(book));
    }

    @Override
    public void remove(Book book) {
        executeInsideTransaction(EntityManager -> em.remove(book));
    }

    @Override
    public Book getBookById(Long id) {
        return em.find(Book.class,id);
    }

    @Override
    public List<Book> getBooksByBookTitle(String title) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE bookTitle=?1");
        return query.setParameter(1, title).getResultList();
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE authorName=?1");
        return query.setParameter(1,authorName).getResultList();
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
