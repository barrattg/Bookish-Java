package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;

import org.jdbi.v3.core.Jdbi;

public class Help implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) {

        System.out.println("Available Commands: " +
                "\nAddBook {name} {ISBN} {date:yyyy-mm-dd}  // Add a new book" +
                "\nAddAuthor {name}  // Add a new author" +
                "\nAddUser {name} {address}  // Add a new User" +
                "\nGetBook  // List all books in the database" +
                "\nGetLoans [UserID]  // Get list of loaned books" +
                "\nGetUser  // List Users" +
                "\nGetAuthors // Get Authors" +
                "\nAUTHOR ADD/LIST  // " +
                "\nBOOK ADD/LIST  // " +
                "\nSearchBook {name} // Search for a book" +
                "\nSearchAuthor {name} // Search for an author"

        );

    }
}
