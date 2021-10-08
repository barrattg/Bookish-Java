package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;

import java.util.HashMap;

public interface Command {
    public void Execute(String input, Jdbi jdbi);
}
