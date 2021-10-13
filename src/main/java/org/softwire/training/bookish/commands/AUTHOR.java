package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;
public class AUTHOR implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) throws Exception {

        if (input.equals("")) {
            System.out.println("Usage: AUTHOR ADD/LIST/REMOVE");
            return;
        }

        String[] data = input.split(" ");

        String parameters = (data.length == 1) ? "" : data[1];

        Class<?> commandClass = Command.class;

        switch (data[0]) {
            case "ADD":
                commandClass = AddAuthor.class;
                break;
            case "LIST" :
                commandClass = GetAuthors.class;
                break;
            case "REMOVE" :
                commandClass = RemoveAuthor.class;
                break;
        }
        commandClass.getDeclaredMethod("Execute", String.class, Jdbi.class).invoke(commandClass.newInstance(), parameters, jdbi);


    }
}
