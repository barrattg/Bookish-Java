package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.Objects;

public class Copy {

    int CopyID;
    int BookID;
    Date LoanedDate;
    //thinking of reserving datetime think of reserve add 3 hour window if elapsed, remove flag.

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

    public Date getLoanedDate() {
        return LoanedDate;
    }

    public void setLoanedDate(Date loanedDate) {
        LoanedDate = loanedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return CopyID == copy.CopyID && BookID == copy.BookID && LoanedDate.equals(copy.LoanedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CopyID, BookID, LoanedDate);
    }

    @Override
    public String toString() {
        return "Copy{" +
                "CopyID=" + CopyID +
                ", BookID=" + BookID +
                ", LoanedDate=" + LoanedDate +
                '}';
    }
}
