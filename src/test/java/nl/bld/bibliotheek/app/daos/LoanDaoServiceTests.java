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
            System.out.println("Loan successfully added.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }

        //Assert
        String queryAllLoans = "SELECT l FROM Loan l";
        Query jpqlQueryAllLoans = em.createQuery(queryAllLoans, Loan.class);
        List<Loan> outcomeQueryAllLoans = jpqlQueryAllLoans.getResultList();

        assertThat(outcomeQueryAllLoans.get(0).getBook().getBookTitle()).isEqualTo("Boek1");
        System.out.println(outcomeQueryAllLoans.get(0).getBook().getBookTitle());
    }

    @Test
    public void testUpdateLoan(){
        //Arrange
        testSaveLoan();
        Book book2 = new Book("Boek2", "Schrijver2", 1);
        Member member2 = new Member();

        //Act
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(book2);
            em.persist(member2);
            Loan adjustedLoan1 = em.find(Loan.class,1);
            adjustedLoan1.setBook(book2);
            adjustedLoan1.setMember(member2);
            tx.commit();
            System.out.println("Loan successfully adjusted.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }

        //Assert
        String queryAllLoans = "SELECT l FROM Loan l where id = 1";
        var jpqlQueryAllLoans = em.createQuery(queryAllLoans, Loan.class);
        Loan outcomeQueryAllLoans = jpqlQueryAllLoans.getSingleResult();

        assertThat(outcomeQueryAllLoans.getBook().getBookTitle()).isEqualTo("Boek2");
        System.out.println(outcomeQueryAllLoans.getBook().getBookTitle());
    }

    @Test
    public void testRemoveLoan(){
        //Arrange
        testUpdateLoan();

        //Act
        String queryAllLoans1 = "SELECT l FROM Loan l";
        var jpqlQueryAllLoans1 = em.createQuery(queryAllLoans1, Loan.class);
        List<Loan> outcomeQueryAllLoans1 = jpqlQueryAllLoans1.getResultList();
        System.out.println("De database bevat voor verwijderen " + outcomeQueryAllLoans1.size() + " element.");

        try {
            tx = em.getTransaction();
            tx.begin();
            Loan loanToBeRemoved = em.find(Loan.class,1);
            em.remove(loanToBeRemoved);
            tx.commit();
            System.out.println("Loan successfully removed.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }

        //Assert
        String queryAllLoans2 = "SELECT l FROM Loan l";
        var jpqlQueryAllLoans2 = em.createQuery(queryAllLoans2, Loan.class);
        List<Loan> outcomeQueryAllLoans2 = jpqlQueryAllLoans2.getResultList();

        assertThat(outcomeQueryAllLoans2.size()).isEqualTo(0);
        System.out.println("De database bevat voor verwijderen " + outcomeQueryAllLoans2.size() + " elementen.");
    }




}
