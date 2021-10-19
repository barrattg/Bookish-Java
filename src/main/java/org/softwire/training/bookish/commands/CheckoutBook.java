package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

import org.softwire.training.bookish.services.DatabaseService;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Copies;

@Service
public class CheckoutBook extends DatabaseService {



    public void Checkout() {
        try {
            Object ReservationSorter = jdbi.withHandle(handle ->

                    handle.createQuery("select Copies.ID, LoanedDate, ReturnedDate from copies " +
                                    "join books on books.ID = copies.BookID " +
                                    "LEFT outer JOIN loans on copies.ID = loans.CopyID " +
                                    "where loans.ID IN (Select max(ID) From loans group by CopyID) OR LoanedDate is Null;")
                            .mapTo(String.class).list()
            );
            System.out.println(ReservationSorter);

        }
        catch (Exception e){
            System.out.println("no");
        }
    }


}
