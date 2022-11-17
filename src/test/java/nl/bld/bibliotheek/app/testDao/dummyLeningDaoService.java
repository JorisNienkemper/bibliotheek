package nl.bld.bibliotheek.app.testDao;

import nl.bld.bibliotheek.app.daos.LoanDaoServiceContract;
import nl.bld.bibliotheek.app.domain.Loan;
import org.example.daos.LeningDaoServiceContract;
import org.example.domain.Loan;

public class dummyLeningDaoService implements LoanDaoServiceContract {
    @Override
    public void save(Loan loan) {

    }

    @Override
    public void update(Loan loan) {

    }

    @Override
    public void remove(Loan loan) {
    }
}
