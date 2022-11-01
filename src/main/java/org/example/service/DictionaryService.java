package org.example.service;

import org.example.dto.Word;
import org.example.repository.DictionaryRepository;
import org.example.util.DictionaryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class DictionaryService {

    private DictionaryRepository dictionaryRepository;


    @Autowired
    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public void addWord(Word word) {

        if (word.getDescription().trim().length() < 3) {
            System.out.println("Description minimum size 3");
            return;
        }


        int i = dictionaryRepository.addWordToDb(word);

        if (i != 0) {
            System.out.println("Word successfully added to dictionary");
            return;
        }

        System.out.println("Failed");
    }

    public void getWordList() {
        List<Word> wordList = dictionaryRepository.getWordList();
        for (Word word : wordList) {
            System.out.println(word);
        }
    }


    public void search(String next) {
        Word word = dictionaryRepository.search(next);
        System.out.println(word);
    }

    public void spelling() {
        List<Word> wordList = dictionaryRepository.getWordList();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean game = true;
        while (game) {

            Word word = wordList.get(random.nextInt(0, wordList.toArray().length));

            String spelling = DictionaryUtil.getSpelling(word.getWord());


            System.out.println((word.getTranslate()));

            System.out.println(spelling + " -> Enter word (0=exit):  ");
            String wordForCheck = scanner.next();


            if (wordForCheck.equals("0")) {
                return;
            }

            if (word.getWord().equals(wordForCheck)) {
                System.out.println("Correct");
                game = false;
            }


        }

    }


    public void multipleChoice() {

        List<Word> wordList = dictionaryRepository.getWordList();
        if (wordList.size() < 4) {
            System.out.println("Words  are not enough");
            return;
        }

        boolean game = true;
        while (game) {
            game = DictionaryUtil.makeTest(wordList);
        }
    }

    public void delete(int id) {
        int i = dictionaryRepository.deleteWord(id);
        if (i != 0) {
            System.out.println("Deleted");
        } else {
            System.out.println("Failed");
        }
    }
}
