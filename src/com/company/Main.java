package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Interpretor in constructie...");
        Analizator a = new Analizator("C:\\Users\\UP\\IdeaProjects\\untitled1\\src\\com\\company\\Input_files\\raza.txt");
        try {
            a.analize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        a.printIPFTable();
        a.printSymbolTable();

//        CodeTable ct = new CodeTable();
//        System.out.println(ct.getCode("U"));
    }
}
