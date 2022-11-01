package org.example.repository;


import org.example.dto.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DictionaryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addWordToDb(Word word) {
        String sql = "insert into  dictionary(word,translate,description,c_d) values (?,?,?,?)";

        return jdbcTemplate.update(sql, word.getWord(), word.getTranslate(),word.getDescription(), word.getCreated_date());
    }


    public List<Word> getWordList() {
        String sql = "select * from dictionary;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class));
    }

    public Word search(String w_n) {
        String sql = "select * from dictionary where word='" + w_n + "';";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Word.class));
    }

    public int deleteWord(int id) {
        String sql = "delete from  dictionary where id=? ;";
        return jdbcTemplate.update(sql, id);
    }
}
