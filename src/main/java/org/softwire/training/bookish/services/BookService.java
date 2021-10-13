package org.softwire.training.bookish.services;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService {

    public List<Book> getAllBooks(){
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        System.out.println(book);
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO books (Name, ISBN, PublishDate) VALUES (:Name, :ISBN, :PublishDate)")
                        .bind("Name", book.getName())
                        .bind("ISBN", book.getISBN())
                        .bind("PublishDate", book.getPublishDate())
                        .execute()
        );
    }

    public void removeBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE ID =:ID")
                        .bind("ID", book.getID())

        );
    }

}
