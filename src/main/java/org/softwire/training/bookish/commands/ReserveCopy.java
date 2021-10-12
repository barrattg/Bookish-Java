package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
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
             System.out.println("im here");
             jdbi.withHandle(handle ->

                 handle.createQuery("Select books.ID FROM books WHERE books.Name =:Name INSERT INTO loans (UserID, CopyID) SELECT :UserID, copies.ID" +
                                 " JOIN books ON books.ID = copies.BookID LEFT OUTER JOIN loans ON copies.ID = loans.CopyID WHERE Books.ID = :UserID AND (loans.UserID IS null or" +
                                 " loans.ReturnedDate is not null)")

                         .bind("Name",bookName)
                         .bind("UserID", UserID)
                         .mapToBean(Book.class)
                         .list()
             )

            ;


        }
         catch (Exception e){
             System.out.println(e);
         }

    }

}
