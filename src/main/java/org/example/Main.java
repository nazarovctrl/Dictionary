package org.example;

import org.example.config.Config;
import org.example.controller.MenuController;
import org.example.db.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

//
//
//        System.out.println("son kiriting: ");
//
//        Scanner scanner=new Scanner(System.in);
//
//        int n = scanner.nextInt();
//
//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j <n; j++) {
//
//                if (i==0||i==n-1||j==0||j==n-1){
//                    System.out.print(n);
//                }else {
//                    System.out.print(" ");
//                }
//
//            }
//            System.out.println();
//        }

        DataBase.initTable();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MenuController menuController = (MenuController) applicationContext.getBean("menuController");
        menuController.start();

    }
}