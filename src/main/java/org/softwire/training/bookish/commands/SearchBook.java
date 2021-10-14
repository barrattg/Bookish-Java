package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class SearchBook implements Command {

    @Override
    public void Execute(String input, Jdbi jdbi) {

        String[] data = input.split(" ");

        List<Book> tempBooks = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.Books WHERE Name LIKE :Title")
                        .bind("Title", data[0])
                        .mapToBean(Book.class)
                        .list()
        );


        tempBooks.forEach(v ->{System.out.println(v);});
    }
}
