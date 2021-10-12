package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ReserveCopy implements Command {
    //checks if any copy is available then takes a copy ID and
    // creates new loan for that users ID with that copy
    //param checkoutDate if null assume today's datetime 2 weeks after is check in

    @Override
    public void Execute(String input, Jdbi jdbi) {
        //todo copy available
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Book Name to be reserved: ");
        String bookName = myObj.nextLine();
        System.out.println("Enter UserID: ");
        String UserID = myObj.nextLine();
        //todo change copy class to have copyID /checkout and remove expected return
         try {

             Object o = jdbi.withHandle(handle ->

                     handle.createUpdate("INSERT INTO loans (UserID, CopyID) SELECT :UserID, copies.ID" +
                                     " FROM copies " +
                                     " JOIN books ON books.ID = copies.BookID " +
                                     " LEFT OUTER JOIN loans ON copies.ID = loans.CopyID " +
                                     " WHERE Books.Name = :Name AND (loans.UserID IS null or" +
                                     " loans.ReturnedDate is not null) " +
                                     " limit 1")

                             .bind("Name", bookName)
                             .bind("UserID", UserID)
                             .execute()

             );
             if (o.toString().equals("0") ) {
                 System.out.println("There were no copies available of " + bookName + " sorry");
             }
             else {
                 System.out.println(bookName + " added to loans table for User " + UserID);
             }
         }
         catch (Exception e){
             System.out.println(e);
         }
            }

    }


