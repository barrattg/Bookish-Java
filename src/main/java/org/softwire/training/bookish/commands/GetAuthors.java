package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Author;

import java.util.List;

public class GetAuthors implements Command{

    @Override
    public void Execute(String input, Jdbi jdbi) {


        List<Author> tempAuthor = jdbi.withHandle(handle ->

                handle.createQuery("Select * FROM authors")
                        .mapToBean(Author.class)
                        .list()


        );

        tempAuthor.forEach(v ->{System.out.println(v);});
    }
}
