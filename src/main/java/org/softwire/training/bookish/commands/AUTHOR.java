package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;

import java.text.SimpleDateFormat;
import java.util.List;
public class AUTHOR implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) throws Exception {

        String[] data = input.split(" ");

        switch (data[0]) {
            case "ADD":

                break;
            case "LIST" :

                break;
            case "REMOVE" :

                break;
        }

    }
}
