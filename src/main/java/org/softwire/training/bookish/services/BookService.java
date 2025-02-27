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

    public Book getBookFromId(Integer bookId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books WHERE ID=:id")
                        .bind("id", bookId)
                        .mapToBean(Book.class)
                        .list().get(0)
        );
    }

    public Integer getBookFromCopy(Integer copyId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT BookID FROM copies WHERE ID = :id ")
                        .bind("id", copyId)
                        .mapTo(Integer.class)
                        .list().get(0)
        );
    }

    public void addBook(Book book) {

        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO books (Name, ISBN, PublishDate) VALUES (:name, :isbn, :publishDate)")
                        .bind("name", book.getName())
                        .bind("isbn", book.getIsbn())
                        .bind("publishDate", book.getPublishDate())
                        .execute()
        );
    }

    public void removeBook(int id) {

        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE ID = :bookId")
                        .bind("bookId", id)
                        .execute()

        );

    }

}
