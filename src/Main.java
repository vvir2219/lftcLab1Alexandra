import tables.CodeTable;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Interpretor in constructie...");
        Analizator a = new Analizator("C:\\Users\\UP\\IdeaProjects\\LFTC Interpretor\\src\\Input_files\\raza.txt");
        try {
            a.analize();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        CodeTable ct = new CodeTable();
//        System.out.println(ct.getCode("U"));
    }
}
