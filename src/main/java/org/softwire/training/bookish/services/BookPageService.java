package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPageService extends DatabaseService {

    public Book GetBook(Integer bookId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Books WHERE ID = :id LIMIT 1")
                        .bind("id", bookId)
                        .mapToBean(Book.class)
                        .list()).get(0);
    }

    public List<Copy> getAllCopies(Integer bookId) {

        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM copies WHERE BookID = :id")
                        .bind("id", bookId)
                        .mapToBean(Copy.class)
                        .list()
                );

    }




}
