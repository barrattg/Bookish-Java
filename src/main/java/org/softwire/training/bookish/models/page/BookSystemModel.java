package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;

import java.util.List;

public class BookSystemModel {

    private List<Book> books;
    private Book redirectBook;

    public Book getRedirectBook() {
        return redirectBook;
    }

    public void setRedirectBook(Book redirectBook) {
        this.redirectBook = redirectBook;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }



}


