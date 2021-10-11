package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class Copy {

    int CopyID;
    int BookID;

    public int getCopyID() {
        return CopyID;
    }

    public void setCopyID(int copyID) {
        CopyID = copyID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "CopyID=" + CopyID +
                ", BookID=" + BookID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return CopyID == copy.CopyID && BookID == copy.BookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CopyID, BookID);
    }
}
