package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class BookCopyForPage {
    int id;
    String loanedDate;
    String returnedDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(String loanedDate) {
        this.loanedDate = loanedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCopyForPage that = (BookCopyForPage) o;
        return id == that.id && Objects.equals(loanedDate, that.loanedDate) && Objects.equals(returnedDate, that.returnedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanedDate, returnedDate);
    }

    @Override
    public String toString() {
        return "BookCopyForPage{" +
                "id=" + id +
                ", loanedDate='" + loanedDate + '\'' +
                ", returnedDate='" + returnedDate + '\'' +
                '}';
    }
}


