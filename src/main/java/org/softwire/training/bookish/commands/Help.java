package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

public class Help implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) {
        System.out.println("Available Commands: none yet!");
    }
}
