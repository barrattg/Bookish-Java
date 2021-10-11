package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.Objects;

public class Loan {

    int ID;
    int UserID;
    int CopyID;

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

    public int getCopyID() {
        return CopyID;
    }

    public void setCopyID(int copyID) {
        CopyID = copyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return ID == loan.ID && UserID == loan.UserID && CopyID == loan.CopyID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, UserID, CopyID);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", CopyID=" + CopyID +
                '}';
    }
}
