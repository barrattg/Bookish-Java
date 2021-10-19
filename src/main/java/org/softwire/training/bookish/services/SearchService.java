package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService extends DatabaseService {

    public List<Book> searchAll(String webBookCriterion, String webAuthorCriterion) {
        String bookCriterion = webBookCriterion == null || webBookCriterion.length() == 0? "%":webBookCriterion;
        String authorCriterion = webAuthorCriterion == null || webAuthorCriterion.length() == 0? "%":webAuthorCriterion;

        return jdbi.withHandle(handle ->
            handle.createQuery("SELECT Authors.ID, Authors.Name aname, Books.Name, Books.ISBN, Books.PublishDate FROM bookish.Authors\n" +
                            "JOIN BooksToAuthors ON Authors.ID = BooksToAuthors.AuthorID\n" +
                            "JOIN Books ON Books.ID = BooksToAuthors.BookID\n" +
                            "WHERE Books.Name LIKE :SearchBooks AND Authors.Name LIKE :SearchAuthors\n" +
                            "ORDER BY Books.Name asc")
                    .bind("SearchBooks", bookCriterion)
                    .bind("SearchAuthors", authorCriterion)
                    .mapToBean(Book.class)
                    .list()
                );
    }
}

// TODO make page that only displays search criteria - make copy of current search.html (call it different)
// Make copy displays search criteria and books

// go to controller & make another method called display similar to search
// in search methods - take away requestparam and calls and return to search page
// when submitted, goes to display method
// add /display to requestmapping (/search/display/...)
