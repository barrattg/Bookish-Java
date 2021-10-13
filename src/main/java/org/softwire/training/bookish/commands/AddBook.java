package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddBook implements Command {


    @Override
    public void Execute(String input, Jdbi jdbi) throws ParseException {

        String[] data = input.split(" ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(input);

        jdbi.withHandle(handle ->
                handle.execute("INSERT INTO books(name, ISBN, PublishDate) VALUES (?, ?, ?)",
                        data[0],
                        data[1],
                        new java.sql.Date(format.parse(data[2]).getTime())
                ));

    }
}