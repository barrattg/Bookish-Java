package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class GetBook implements Command {

        @Override
        public void Execute(String input, Jdbi jdbi) {
            List<Book> tempBooks = jdbi.withHandle(handle ->
                    handle.createQuery("Select * FROM books")
                            .mapToBean(Book.class)
                            .list()
            );


             tempBooks.forEach(v ->{System.out.println(v);});
        }
    }

