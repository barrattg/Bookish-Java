package org.softwire.training.bookish.models.database;

import java.util.Objects;

public class User {

    int ID;
    String Name;
    String Address;

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID && Name.equals(user.Name) && Objects.equals(Address, user.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Address);
    }
}
