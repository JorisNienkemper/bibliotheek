package nl.bld.bibliotheek.app.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nl.bld.bibliotheek.app.domain.Book;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoServiceTests {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheek-pu-test");
    private final EntityManager em = emf.createEntityManager();

    private final BookDaoService bookDao = new BookDaoService();

    @BeforeEach
    public void setUp() {
        em.getTransaction().begin();
        em.persist(new Book("A","B",3));
        em.getTransaction().commit();
    }

    @Test
    @Order(1)
    public void getTests() {
        long id = 1;
        Optional<Book> book = bookDao.get(id);
        assertThat(book).isNotEmpty();
    }

    @Test
    @Order(2)
    public void getBooksTests() {
        List<Book> books = bookDao.getBooks();
        assertThat(books.get(0).getBookTitle()).isEqualTo("A");
    }

    @Test
    @Order(3)
    public void saveTests() {
        Book book = new Book("Z","Y",9);
        bookDao.save(book);
        assertThat(bookDao.getBooks().get(1).getBookTitle()).isEqualTo("Z");
    }

    @Test
    @Order(4)
    public void updateTests() {
        Book book = bookDao.getBookById(1L);
        book.setBookQuantity(8);
        bookDao.update(book);
        assertThat(bookDao.getBooks().get(0).getBookQuantity()).isEqualTo(8);
    }

    @Test
    @Order(8)
    public void removeTests() {
        Book book = bookDao.getBookById(1L);
        bookDao.remove(book);
        assertThat(bookDao.get(0)).isEmpty();
    }

    @Test
    @Order(5)
    public void getBookByIdTests() {
        Book book = bookDao.getBookById(1L);
        assertThat(book.getSerialNumber()).isEqualTo(1L);
    }

    @Test
    @Order(6)
    public void getBooksByNameTests() {
        List<Book> books = bookDao.getBooksByBookTitle("A");
        assertThat(books.get(0).getBookTitle()).isEqualTo("A");
    }

    @Test
    @Order(7)
    public void getBooksByAuthorName() {
        List<Book> books = bookDao.getBooksByAuthorName("B");
        assertThat(books.get(0).getAuthorName()).isEqualTo("B");
    }
}