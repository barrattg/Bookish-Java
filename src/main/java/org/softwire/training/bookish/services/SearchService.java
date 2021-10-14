package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService extends DatabaseService {

    public List<Book> searchAll() {
        // String bookCriterion = data.length > 0 && data[0].length() > 0? data[0]:"%";
        // String authorCriterion = data.length > 1? data[1]:"%";



        return jdbi.withHandle(handle ->
            handle.createQuery("SELECT Authors.ID, Authors.Name aname, Books.Name, Books.ISBN, Books.PublishDate FROM bookish.Authors\n" +
                            "JOIN BooksToAuthors ON Authors.ID = BooksToAuthors.AuthorID\n" +
                            "JOIN Books ON Books.ID = BooksToAuthors.BookID\n" +
                            "WHERE Books.Name LIKE :SearchBooks AND Authors.Name LIKE :SearchAuthors")
                    //.bind("SearchBooks", bookCriterion)
                    //.bind("SearchAuthors", authorCriterion)
                    .mapToBean(Book.class)
                    .list()
                );
    }
}
