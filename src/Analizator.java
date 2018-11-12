
import tables.CodeTable;
import tables.IPFTable;
import tables.SymbolTable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Analizator {

    private String filename;
    private CodeTable codeTable;
    private SymbolTable symbolTable;
    private IPFTable ipfTable;
    private List<CodeError> codeErrors;

    public Analizator(String filename) {
        this.filename = filename;
        codeTable = new CodeTable();
        symbolTable = new SymbolTable();
        ipfTable = new IPFTable();
    }

    public void analize() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line;
        char character;
        String prefix= "";
        String match = "";

        while((line = bufferedReader.readLine()) != null) {
            {
                Integer i = 0;
                while(i < line.length())
                {
                    while(i < line.length() && Character.isWhitespace(line.charAt(i))) i++;
                    if (i < line.length())
                        prefix = prefix + line.charAt(i);

                    if(i < line.length() && codeTable.numberOfMatches(prefix) != 0)
                    {
                        if(checkIfInCodeTable(prefix) == true)
                            match = prefix;
                    }
                    else
                    {
                        if (match != "")
                            System.out.println(match);
                        else {
                            System.out.println("not in code table");
                            break;
                        }
                        prefix = "";
                        match = "";
                        i--;
                    }


                    i++;
                }
            }


    }
    }

    private boolean checkIfInCodeTable(String code)
    {

        if(codeTable.getCode(code) != null)
            return true;

        return false;
    }

}
