package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Dictionary", "java_db_user", "123");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public static void initTable() {

        String dictionary = "create table  if not exists dictionary(id serial primary key, " +
                "word varchar not null," +
                "translate varchar  not null, " +
                "description varchar, " +
                "c_d timestamp not null );";
        execute(dictionary);

    }

    private static void execute(String sql) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
