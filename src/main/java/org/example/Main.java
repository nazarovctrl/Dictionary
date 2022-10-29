package org.example;

import org.example.config.Config;
import org.example.controller.MenuController;
import org.example.db.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;


public class Main {


    public static void main(String[] args) {

        DataBase.initTable();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MenuController menuController = (MenuController) applicationContext.getBean("menuController");
        menuController.start();

    }
}