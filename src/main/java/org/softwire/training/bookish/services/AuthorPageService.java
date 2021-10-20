package org.softwire.training.bookish.services;

import org.softwire.training.bookish.commands.AddAuthor;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.BookToAuthor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorPageService extends DatabaseService {

    public List<Book> getAllAuthorBooks(Integer authorID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Books\n" +
                                "Inner join BooksToAuthors\n" +
                                "on Books.ID = BooksToAuthors.BookID\n" +
                                "where AuthorID = :id")
                        .bind("id", authorID)
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public Author GetAuthor(Integer authorID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Authors WHERE ID = :id")
                        .bind("id", authorID)
                        .mapToBean(Author.class)
                        .list()
                ).get(0);
    }


}
