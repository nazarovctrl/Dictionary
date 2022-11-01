package org.example.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DataBase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initTable() {

        String dictionary = "create table  if not exists dictionary(id serial primary key, " +
                "word varchar not null," +
                "translate varchar  not null, " +
                "description varchar, " +
                "c_d timestamp not null );";
          jdbcTemplate.update(dictionary);

    }

    public int dropTable(){

        String sql="drop table dictionary ;";
        return jdbcTemplate.update(sql);
    }


}
