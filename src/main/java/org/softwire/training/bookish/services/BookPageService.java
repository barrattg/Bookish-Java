package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
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
                handle.createQuery("select copies.Id, bookId from copies " +
                        "        join books on books.ID = copies.BookID " +
                        "        LEFT outer JOIN loans on copies.ID = loans.CopyID " +
                        "        where bookId =:id and ((loans.ID IN (Select max(ID) From loans group by CopyID) and LoanedDate is not null and ReturnedDate is not null) OR LoanedDate is Null);")
                        .bind("id", bookId)
                        .mapToBean(Copy.class)
                        .list()
                );

    }





}
