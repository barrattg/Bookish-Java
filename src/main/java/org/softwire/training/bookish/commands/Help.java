package org.softwire.training.bookish.commands;
import org.jdbi.v3.core.Jdbi;

import org.jdbi.v3.core.Jdbi;

public class Help implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) {

        System.out.println("Available Commands: " +
                "\n\nADD ENTRIES\n-----" +
                "\nAddBook {name} {ISBN} {date:yyyy-mm-dd} | Adds a new book" +
                "\nAddAuthor {name} | Adds a new author" +
                "\nAddUser {name} {address} | Adds a new User" +
                "\n\nGET ENTRIES\n-----" +
                "\nGetBook | Lists all books in the database" +
                "\nGetAuthors | Lists all authors" +
                "\nGetUser | Lists all users" +
                "\nGetLoans (Broken)| Lists all loaned books for specified user" +
                "\n\nSEARCH ENTRIES (Broken in console)\n-----" +
                "\nSearchBook {name} | Search for a book" +
                "\nSearchAuthor {name} | Search for an author" +
                "\nSearch {book name} OR % {author name} | Search for book or author"
        );

    }
}
