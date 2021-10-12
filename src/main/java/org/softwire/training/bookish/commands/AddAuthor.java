package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddAuthor implements Command{

    @Override
    public void Execute(String input, Jdbi jdbi) throws ParseException {

        String[] data = input.split(" ");

        jdbi.withHandle(handle ->
                handle.execute("INSERT INTO Authors(name) VALUES (?)",
                        data[0]
                ));

    }
}
