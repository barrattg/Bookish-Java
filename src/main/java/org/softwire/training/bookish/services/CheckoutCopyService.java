package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.services.DatabaseService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class CheckoutCopyService extends DatabaseService {
    public void createReservation(int copyID,int UserID){
        String LoanedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(java.time.LocalDate.now());

       List<Integer> checker = jdbi.withHandle(handle ->

                handle.createQuery(
                        "select Copies.ID from copies " +
                                "        join books on books.ID = copies.BookID " +
                                "        LEFT outer JOIN loans on copies.ID = loans.CopyID " +
                                "        where (loans.ID IN (Select max(ID) From loans group by CopyID) and LoanedDate is not null and ReturnedDate is not null) OR LoanedDate is Null;"

                ).mapTo(Integer.class).list());

        if (checker.contains(copyID)) {
            jdbi.withHandle(handle ->
                    handle.createUpdate("INSERT INTO loans (UserID, CopyID, LoanedDate) VALUES ( :UserID, :CopyID, :LoanedDate) ")
                            .bind("CopyID", copyID)
                            .bind("UserID", UserID)
                            .bind("LoanedDate", LoanedDate)
                            .execute()

            );}
            else{
                System.out.println("This book is not currently available, sorry ");
            }
        }

    }

