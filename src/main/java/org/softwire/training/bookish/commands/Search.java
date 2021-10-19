package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class Search implements Command {

    @Override
    public void Execute(String input , Jdbi jdbi) {

        String[] data = input.split(" ");

        String bookCriterion = data.length > 0 && data[0].length() > 0? data[0]:"%";
        String authorCriterion = data.length > 1? data[1]:"%";

        List<Book> tempSearch = jdbi.withHandle(handle ->
                handle.createQuery("SELECT Authors.ID, Authors.Name aname, Books.Name, Books.ISBN, Books.PublishDate FROM bookish.Authors\n" +
                        "JOIN BooksToAuthors ON Authors.ID = BooksToAuthors.AuthorID\n" +
                        "JOIN Books ON Books.ID = BooksToAuthors.BookID\n" +
                        "WHERE Books.Name LIKE :SearchBooks AND Authors.Name LIKE :SearchAuthors")
                        .bind("SearchBooks", bookCriterion)
                        .bind("SearchAuthors", authorCriterion)
                        .mapToBean(Book.class)
                        .list()
        );

        tempSearch.forEach(v ->{System.out.println(v);});
    }
}
