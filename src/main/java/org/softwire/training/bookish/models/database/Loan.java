package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.Objects;

public class Loan {

    int ID;
    int UserID;
    int BookID;
    Date CheckoutDate;
    Date ExpectedReturnDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public Date getCheckoutDate() {
        return CheckoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        CheckoutDate = checkoutDate;
    }

    public Date getExpectedReturnDate() {
        return ExpectedReturnDate;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        ExpectedReturnDate = expectedReturnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", BookID=" + BookID +
                ", CheckoutDate=" + CheckoutDate +
                ", ExpectedReturnDate=" + ExpectedReturnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return ID == loan.ID && UserID == loan.UserID && BookID == loan.BookID && CheckoutDate.equals(loan.CheckoutDate) && ExpectedReturnDate.equals(loan.ExpectedReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, UserID, BookID, CheckoutDate, ExpectedReturnDate);
    }
}
