package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ReturnCopy implements Command {

    @Override
    public void Execute(String input, Jdbi jdbi) throws ParseException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Enter LoanID: ");
        String LoanID = myObj.nextLine();
        String ReturnedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(java.time.LocalDate.now());

        Object o = jdbi.withHandle(handle ->
                handle.createUpdate("UPDATE loans SET ReturnedDate = '2002-08-03' WHERE Loans.ID =:ID"


                )
                        .bind("ID", LoanID)
                        .execute()
        );
        System.out.println("Loan for " + LoanID + " now returned");
        }
    }

