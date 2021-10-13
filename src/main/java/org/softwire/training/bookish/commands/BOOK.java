package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;

import java.text.SimpleDateFormat;
import java.util.List;
public class BOOK implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) throws Exception {

        if (input.equals("")) {
            System.out.println("Usage: BOOK ADD/LIST/CHECKOUT/CHECKIN/REMOVE");
            return;
        }

        String[] data = input.split(" ", 2);

        String parameters = (data.length == 1) ? "" : data[1];

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Class<?> commandClass = Command.class;

        switch (data[0]) {
            case "ADD":
                commandClass = AddBook.class;
                break;
            case "LIST" :
                commandClass = GetBook.class;
                break;
            case "CHECKOUT" :

                break;
            case "CHECKIN" :

                break;
            case "REMOVE" :
                commandClass = RemoveBook.class;
                break;
        }

        commandClass.getDeclaredMethod("Execute", String.class, Jdbi.class).invoke(commandClass.newInstance(), parameters, jdbi);

    }
}
