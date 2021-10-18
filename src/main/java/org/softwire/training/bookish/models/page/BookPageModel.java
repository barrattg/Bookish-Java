package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;

import java.util.List;

public class BookPageModel {

    private Book book;
    private List<Copy> copies;

    public void SetBook(Book book) {this.book = book; }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public Book getBook() {
        return book;
    }


}
