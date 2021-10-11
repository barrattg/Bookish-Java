package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.Objects;

public class Copy {

    int CopyID;
    int BookID;
    Date ReturnDate;

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

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "CopyID=" + CopyID +
                ", BookID=" + BookID +
                ", ReturnDate=" + ReturnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return CopyID == copy.CopyID && BookID == copy.BookID && Objects.equals(ReturnDate, copy.ReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CopyID, BookID, ReturnDate);
    }

}
