import tables.CodeTable;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Interpretor in constructie...");
        Analizator a = new Analizator("./test.txt");
        try {
            a.analize();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        CodeTable ct = new CodeTable();
//        System.out.println(ct.getCode("U"));
    }
}
