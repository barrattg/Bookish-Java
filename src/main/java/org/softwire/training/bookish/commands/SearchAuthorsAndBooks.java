package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Author;


import java.util.List;

public class SearchAuthorsAndBooks implements Command {

    @Override
    public void Execute(String input, Jdbi jdbi) {

        String[] data = input.split(" ");

        List<Author> tempAuthor = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.Books\n" +
                                "INNER JOIN BooksToAuthors ON Books.ID = BooksToAuthors.BookID\n" +
                                "JOIN bookish.Authors ON Authors.ID = BooksToAuthors.AuthorID\n" +
                                "WHERE Books.Name LIKE '%' AND Authors.Name LIKE '%'\n")
                        .bind("SearchTerm", data[0])
                        .mapToBean(Author.class)
                        .list()
        );


        tempAuthor.forEach(v ->{System.out.println(v);});
    }
}
