package nl.bld.bibliotheek.app.daos;


import nl.bld.bibliotheek.app.domain.Loan;

public interface LoanDaoServiceContract {

    void save(Loan loan);

    void update(Loan loan);

    void remove(Loan loan);

}
