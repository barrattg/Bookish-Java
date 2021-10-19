package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;

import java.util.List;

public class BookSystemModel {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getBlankMessage() {
        return blankMessage;
    }

    public void setBlankMessage(String blankMessage) {
        this.blankMessage = blankMessage;
    }

    private String blankMessage;


}


