package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.Objects;

public class Book {

    private int ID;
    private String Name;
    private String ISBN;
    private Date PublishDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date publishDate) {
        PublishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", PublishDate=" + PublishDate +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID && Name.equals(book.Name) && ISBN.equals(book.ISBN) && Objects.equals(PublishDate, book.PublishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, ISBN, PublishDate);
    }
}
