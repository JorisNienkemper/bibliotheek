package nl.bld.bibliotheek.app.daos;

import jakarta.persistence.*;
import nl.bld.bibliotheek.app.App;
import nl.bld.bibliotheek.app.domain.Loan;

public class LoanDaoService implements LoanDaoServiceContract{

    //TODO verwijderen nadat geimplementeerd
    String persistenceUnitName = "bibliotheek-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public void save(Loan loan) {
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(loan);
            tx.commit();
            System.out.println("Loan successfully added.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }
    }

    //Deze moet nog ingevuld worden.
    @Override
    public void update(Loan loan) {

    }

    //Nog niet kunnen testen of deze goed werkt. Test moet nog aangepast worden.
    @Override
    public void remove(Loan loan) {
        try {
            tx = em.getTransaction();
            tx.begin();

            String queryAllLoans = "SELECT l.id FROM Loan l where l = :loan";
            var jpqlQueryAllLoans = em.createQuery(queryAllLoans, Integer.class)
                    .setParameter("loan", loan);
            Integer outcomeQueryRemoveLoan = jpqlQueryAllLoans.getSingleResult();
            Loan loanToBeRemoved = em.find(Loan.class,outcomeQueryRemoveLoan);
            em.remove(loanToBeRemoved);

            tx.commit();
            System.out.println("Loan successfully removed.");
        } catch (Exception e){
            if (em != null){
                em.getTransaction().rollback();
                throw new RuntimeException("Something unexpected went wrong", e);
            }
        }
    }
}
