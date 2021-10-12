package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Author;

import java.util.List;

public class SearchAuthor implements Command{

    @Override
    public void Execute(String input, Jdbi jdbi) {

        String[] data = input.split(" ");

        List<Author> tempAuthor = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.Authors WHERE Name LIKE :AuthorName")
                        .bind("AuthorName", data[0])
                        .mapToBean(Author.class)
                        .list()
        );


        tempAuthor.forEach(v ->{System.out.println(v);});
    }
}
