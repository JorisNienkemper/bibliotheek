package nl.bld.bibliotheek.app.daos;

import jakarta.persistence.*;
import nl.bld.bibliotheek.app.App;
import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Loan;
import nl.bld.bibliotheek.app.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanDaoServiceTests {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheek-pu-test");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx;


    @Test
    public void testSaveLoan(){
        //Arrange
        tx = em.getTransaction();

        Book book1 = new Book("Boek1", "Schrijver1", 1);
        Member member1 = new Member();
        Loan loan1 = new Loan();
        loan1.setBook(book1);
        loan1.setMember(member1);

        //Act
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(book1);
            em.persist(member1);
            em.persist(loan1);
            tx.commit();
            System.out.println("Loan succesfully added.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }

        //Assert
        String queryAllLoans = "SELECT l FROM Loan l";
        Query jpqlQueryAllLoans = em.createQuery(queryAllLoans, Loan.class);
        List<Loan> outcomeQueryPersonenAanwezig = jpqlQueryAllLoans.getResultList();

        assertThat(outcomeQueryPersonenAanwezig.get(0).getBook().getBookTitle()).isEqualTo("Boek1");
        System.out.println(outcomeQueryPersonenAanwezig.get(0).getBook().getBookTitle());
    }




}
