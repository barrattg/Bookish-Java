package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoveBook implements Command {


    @Override
    public void Execute(String input, Jdbi jdbi) throws ParseException {

        if (input.equals("")) {
            System.out.println("Please provide an ID");
            return;
        }

        String[] data = input.split(" ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        jdbi.withHandle(handle ->
                handle.execute("DELETE FROM books WHERE ID =?",
                        data[0]
                ));

    }
}