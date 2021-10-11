package org.softwire.training.bookish;


import org.jdbi.v3.core.Jdbi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        
        String hostname = "localhost";
        String database = "bookish";
        String user = "bookish";
        String password = "bookish";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";
        ReadEvaluatePrint.Loop(jdbiMethod(connectionString));

    }

    private static Jdbi jdbiMethod(String connectionString) throws SQLException {
        System.out.println("JDBI method...");
        Connection connection = DriverManager.getConnection(connectionString);
        Jdbi jdbi = Jdbi.create(connectionString);

        return jdbi;
    }

}




