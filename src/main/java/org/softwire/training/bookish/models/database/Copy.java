package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class Copy {

    int id;
    int BookID;
    //thinking of reserving datetime think of reserve add 3 hour window if elapsed, remove flag.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return this.id == copy.id && BookID == copy.BookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, BookID);
    }

    @Override
    public String toString() {
        return "Copy{" +
                "CopyID=" + id +
                ", BookID=" + BookID +
                '}';
    }
}
