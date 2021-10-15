package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;

public class BookPageModel {

    private Book book;

    public void SetBook(Book book) {this.book = book; }

    public Book getBook() {
        return book;
    }

}
