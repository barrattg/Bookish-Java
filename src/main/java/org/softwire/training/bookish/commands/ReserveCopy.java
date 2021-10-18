package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

public class ReserveCopy implements Command {
    //checks if any copy is available then takes a copy ID and
    // creates new loan for that users ID with that copy
    //param checkoutDate if null assume today's datetime 2 weeks after is check in

    @Override
    public void Execute(String input, Jdbi jdbi) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Book ID to be reserved: ");
        String bookID = myObj.nextLine();
        System.out.println("Enter UserID: ");
        String UserID = myObj.nextLine();

        String LoanedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(java.time.LocalDate.now());


         try {

             Object o = jdbi.withHandle(handle ->

                     handle.createUpdate("INSERT INTO loans (UserID, CopyID, LoanedDate) SELECT :UserID, copies.ID, :LoanedDate " +
                     "FROM copies "+
                     "JOIN books ON books.ID = copies.BookID "+
                     "LEFT OUTER JOIN loans ON copies.ID = loans.CopyID " +
                     "WHERE Books.ID =:ID AND ( loans.CopyID IS null OR copies.ID NOT IN (Select copies.ID FROM loans " +
                     "JOIN copies ON loans.CopyID= copies.ID " +
                     "WHERE ReturnedDate IS NULL)) " +
                     "limit 1; ")

                             .bind("ID", bookID)
                             .bind("UserID", UserID)
                             .bind("LoanedDate", LoanedDate)
                             .execute()

             );
             if (o.toString().equals("0") ) {
                 System.out.println("There were no copies available of " + bookID + " sorry");



                 String date = jdbi.withHandle(handle ->

                         handle.createQuery("SELECT LoanedDate FROM LOANS " +
                                 "JOIN copies ON loans.CopyID = copies.ID " +
                                 "JOIN books ON books.ID = copies.BookID " +
                                 "WHERE Books.ID =:ID AND " +
                                 "(loanedDate is NOT NULL and ReturnedDate is NULL) order by LoanedDate asc Limit 1 ;" )
                                 //.map((rs, ctx)-> rs.getString("LoanedDate"))
                                 .bind("ID", bookID)
                                 .mapTo(String.class)
                                 .list().get(0)
                                 );


                 LocalDate futureDate = LocalDate.parse(date).plusDays(7);

                 System.out.println("Would you like to reserve the first available copy on the " + futureDate + " ? yes/no");

                 String reserve = myObj.nextLine();


                 if(reserve.equals("yes")){

                     Object q = jdbi.withHandle(handle ->

                             handle.createUpdate("INSERT INTO loans (UserID, CopyID, LoanedDate) SELECT :UserID, copies.ID, :LoanedDate " +
                             "FROM copies "+
                             "JOIN books ON books.ID = copies.BookID "+
                             "LEFT OUTER JOIN loans ON copies.ID = loans.CopyID " +
                             "WHERE Books.ID =:ID limit 1"
                             )
                                     .bind("ID", bookID)
                                     .bind("UserID", UserID)
                                     .bind("LoanedDate", futureDate)
                                     .execute()
                     );
                     System.out.println("Copy " + bookID + " was reserved on " +futureDate + " for user " + UserID);

                 }
                 else{
                     System.out.println("Please contact a librarian to reserve the book for another date ");

                 }
             }




             else {
                 System.out.println(bookID + " added to loans table for User " + UserID);
             }
         }
         catch (Exception e){
             System.out.println(e);
         }
            }

    }


