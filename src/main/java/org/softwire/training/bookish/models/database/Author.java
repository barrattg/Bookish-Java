package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class Author {

    int ID;
    String Name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return ID == author.ID && Name.equals(author.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name);
    }
}
