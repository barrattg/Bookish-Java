package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

@Service
public class BookPageService extends DatabaseService {

    public Book GetBook(Integer bookID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Books WHERE ID = :id LIMIT 1")
                        .bind("id", bookID)
                        .mapToBean(Book.class)
                        .list()).get(0);
    }

}
