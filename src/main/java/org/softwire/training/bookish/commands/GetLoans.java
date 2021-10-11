package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.User;
import org.springframework.validation.DataBinder;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GetLoans implements Command {

    @Override
    public void Execute(String input, Jdbi jdbi) {


        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter userID, leave blank to get a list of all currently loaned books: ");
        String userID = myObj.nextLine();


        if(userID == "") {
            jdbi.withHandle(handle ->

                    handle.createQuery("Select * FROM loans ")
                            .mapToBean(Loan.class)
                            .list()

            ).forEach(v -> {
                System.out.println(v);
            });
        }
        else {
            try {
                jdbi.withHandle(handle ->

                        handle.createQuery("Select * FROM loans where UserID =:UserID")
                                .bind("UserID",userID)
                                .mapToBean(Loan.class)
                                .list()

                ).forEach(v -> {
                    System.out.println(v);


                });


            }
            catch (Exception e){

                System.out.println("User ID invalid");

            }
        }

    }
}
