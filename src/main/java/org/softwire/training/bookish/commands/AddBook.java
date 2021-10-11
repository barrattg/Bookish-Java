package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddBook implements Command {


    @Override
    public void Execute(String input, Jdbi jdbi) {

        String[] data = input.split(" ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            jdbi.withHandle(handle ->
                    handle.execute("INSERT INTO books(name, ISBN, PublishDate) VALUES (?, ?, ?)",
                            data[1],
                            data[2],
                            new java.sql.Date(format.parse(data[3]).getTime())
                    ));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}