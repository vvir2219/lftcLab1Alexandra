
import tables.CodeTable;
import tables.IPFTable;
import tables.SymbolTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.cert.TrustAnchor;
import java.util.List;

public class Analizator {

    private String filename;
    private CodeTable codeTable;
    private SymbolTable symbolTable;
    private IPFTable ipfTable;
    private List<CodeError> codeErrors;
    private TokenMatcher codeTableMatcher;

    public Analizator(String filename) {
        this.filename = filename;
        codeTable = new CodeTable();
        symbolTable = new SymbolTable();
        ipfTable = new IPFTable();
        codeTableMatcher = new CodeTableMatcher(codeTable);
    }

    public void analize() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            {
                StringIterator iterator = new StringIterator(line);
                while (iterator.valid()) {
                    skipWhitespace(iterator);

                    Match match = codeTableMatcher.match(iterator);
                    if (match.isValid())
                        System.out.println(match.getValue() + " = " + match.getToken().get());
                    else {
                        System.out.println("Nu match code table, nu bun");
                        break;
                    }
                }
            }


        }
    }

    private void skipWhitespace(StringIterator iterator) {
        while (Character.isWhitespace(iterator.current()))
            iterator.next();
    }
}
