package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class BookToAuthor {

    int BookID;
    int AuthorID;

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }

    @Override
    public String toString() {
        return "BookToAuthor{" +
                "BookID=" + BookID +
                ", AuthorID=" + AuthorID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookToAuthor that = (BookToAuthor) o;
        return BookID == that.BookID && AuthorID == that.AuthorID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(BookID, AuthorID);
    }
}
