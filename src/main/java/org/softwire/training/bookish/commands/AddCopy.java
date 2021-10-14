package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

public class AddCopy implements Command{

    @Override
    public void Execute(String input, Jdbi jdbi) {
        System.out.println("Please enter the bookID to add copies of >>> ");
    }
}
