package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoansService extends DatabaseService {

    public List<Loan> getAllLoans() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Loans")
                        .mapToBean(Loan.class)
                        .list()
                );
    }

}
