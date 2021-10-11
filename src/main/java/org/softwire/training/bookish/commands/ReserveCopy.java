package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;
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
        //todo change copy class to have copyID /checkout and remove expected return
         try {
             System.out.println("im here");
             jdbi.withHandle(handle ->

                 handle.createQuery("Select ID FROM books WHERE books.Name =:Name ")
                         .bind("Name",bookName)
                         .mapToBean(Book.class)
                         .list()

            );

        }
         catch (Exception e){
             System.out.println("Exception");
         }

    }

}
