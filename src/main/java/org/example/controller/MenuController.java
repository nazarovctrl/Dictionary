package org.example.controller;

import org.example.dto.Word;
import org.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Scanner;

@Controller
public class MenuController {

    private DictionaryService dictionaryService;


    @Autowired
    public MenuController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public void start() {
        boolean game = true;
        while (game) {
            menu();
            int action = getAction();
            switch (action) {
                case 1 -> addWord();
                case 2 -> getWordList();
                case 3 -> multipleChoice();
                case 4 -> spelling();
                case 5 -> searching();
                case 6 -> deleteById();
                case 0 -> game = false;
                default -> System.out.println("Nimabu mazgi");
            }
        }


    }

    private void deleteById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id:");
        int id = scanner.nextInt();
        dictionaryService.delete(id);
    }

    private void searching() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word");
        String next = scanner.next();

        dictionaryService.search(next);

    }

    private void spelling() {
        dictionaryService.spelling();
    }


    private void multipleChoice() {
        dictionaryService.multipleChoice();

    }

    private void getWordList() {
        dictionaryService.getWordList();
    }

    private void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word_name = scanner.next();

        System.out.print("Enter translate: ");
        String translate = scanner.next();

        scanner = new Scanner(System.in);
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Word word = new Word(word_name, translate, description, LocalDateTime.now());
        System.out.println(word);
        dictionaryService.addWord(word);

    }


    private void menu() {
        System.out.println("** Menu **");
        System.out.println("1. Add Word");
        System.out.println("2. WordList");
        System.out.println("3. Multiple Choice");
        System.out.println("4. Spelling");
        System.out.println("5. Searching");
        System.out.println("6. Delete by id");
        System.out.println("0. Exit");

    }


    private int getAction() {
        while (true) {
            try {
                System.out.print("Enter action: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();

            } catch (RuntimeException ignored) {
                System.out.println("Mazgi son kirit");
            }
        }
    }


}
