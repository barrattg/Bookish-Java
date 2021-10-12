package org.softwire.training.bookish.commands;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;

import java.text.SimpleDateFormat;
import java.util.List;
public class BOOK implements Command {
    @Override
    public void Execute(String input, Jdbi jdbi) throws Exception {

        String[] data = input.split(" ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        switch (data[0]) {
            case "ADD":

                jdbi.withHandle(handle ->
                        handle.execute("INSERT INTO books(name, ISBN, PublishDate) VALUES (?, ?, ?)",
                                data[1],
                                data[2],
                                new java.sql.Date(format.parse(data[3]).getTime())
                        ));
                break;
            case "LIST" :
                jdbi.withHandle(handle ->
                        handle.createQuery("Select * FROM books")
                                .mapToBean(Book.class)
                                .list()
                ).forEach(System.out::println);
                break;
            case "CHECKOUT" :

                break;
            case "CHECKIN" :

                break;
            case "REMOVE" :

                break;
        }

    }
}
