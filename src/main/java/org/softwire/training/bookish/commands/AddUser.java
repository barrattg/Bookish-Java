package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.User;

public class AddUser implements Command {


    @Override
    public void Execute(String input, Jdbi jdbi) {

        String[] data = input.split(" ");


        jdbi.withHandle(handle ->

                handle.execute("INSERT INTO users(id, name, address) VALUES (?, ?, ?)",data));




    }
}