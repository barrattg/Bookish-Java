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


            jdbi.withHandle(handle ->
                    handle.createUpdate("INSERT INTO loans (UserID, CopyID, LoanedDate) VALUES ( :UserID, :CopyID, :LoanedDate) ")
                            .bind("CopyID", copyID)
                            .bind("UserID", UserID)
                            .bind("LoanedDate", LoanedDate)
                            .execute()

            );}


        }



