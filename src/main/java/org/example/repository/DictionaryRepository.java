package org.example.repository;

import org.example.db.DataBase;
import org.example.dto.Word;
import org.example.util.DictionaryUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DictionaryRepository {


    public int addWordToDb(Word word) {
        Connection connection = null;

        try {
            connection = DataBase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  dictionary(word,translate,description,c_d) " +
                    "values (?,?,?,?)");


            preparedStatement.setString(1, word.getName());
            preparedStatement.setString(2, word.getTranslate());
            preparedStatement.setString(3, word.getDescription());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(word.getCreated_date()));

            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return 0;

    }


    public List<Word> getWordList() {
        Connection connection = null;

        try {
            connection = DataBase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dictionary;");

            List<Word> wordList = new LinkedList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wordList.add(DictionaryUtil.getWord(resultSet));
            }
            return wordList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public Word search(String w_n) {
        Connection connection = null;

        try {
            connection = DataBase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dictionary where word=?");

            preparedStatement.setString(1, w_n);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return DictionaryUtil.getWord(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public int deleteWord(int id) {
        Connection connection = null;



        try {
            connection = DataBase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from  dictionary where id=? ");

            preparedStatement.setInt(1, id);

            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return 0;
    }
}
