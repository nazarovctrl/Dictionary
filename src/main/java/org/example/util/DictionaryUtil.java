package org.example.util;

import org.example.dto.Word;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class DictionaryUtil {

    public static Word getWord(ResultSet resultSet) {

        try {
            int id = resultSet.getInt("id");
            String word_name = resultSet.getString("word");
            String translate = resultSet.getString("translate");
            String description = resultSet.getString("description");
            LocalDateTime localDateTime = resultSet.getTimestamp("c_d").toLocalDateTime();

            return new Word(id, word_name, translate, description, localDateTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String getSpelling(String word) {

        Random random = new Random();

        int i = random.nextInt(0, word.length());

        String t = word.substring(0, i);

        t += word.substring(i + 1);
        return t;
    }

    public static boolean makeTest(List<Word> wordList) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int n = random.nextInt(0, wordList.toArray().length);
            if (array.contains(n)) {
                i--;
                continue;
            }
            array.add(n);
        }
        int trueAnswerIndex = random.nextInt(0, 4);

        Word trueAnswer = wordList.get(array.get(trueAnswerIndex));
        System.out.println(trueAnswer.getWord());

        Word word = wordList.get(array.get(0));
        Word word1 = wordList.get(array.get(1));
        Word word2 = wordList.get(array.get(2));
        Word word3 = wordList.get(array.get(3));

        System.out.println("a." + word.getTranslate());
        System.out.println("b." + word1.getTranslate());
        System.out.println("c." + word2.getTranslate());
        System.out.println("d." + word3.getTranslate());
        System.out.print("Enter variant:");
        String variant = scanner.next();

        if (trueAnswerIndex == 0 && variant.equals("a") || trueAnswerIndex == 1 && variant.equals("b")
                || trueAnswerIndex == 2 && variant.equals("c") || trueAnswerIndex == 3 && variant.equals("d")) {
            return false;
        }


        return true;

    }
}
