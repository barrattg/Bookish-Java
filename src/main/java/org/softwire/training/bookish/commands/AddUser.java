package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.User;

public class AddUser implements Command {


    @Override
    public void Execute(String input, Jdbi jdbi) throws Exception {

        String[] data = input.split(" ");

        try {
            jdbi.withHandle(handle ->
                    handle.execute("INSERT INTO users(id, name, address) VALUES (?, ?, ?)", data));
        }
        catch (Exception e) {
            System.out.println();
        }





    }
}