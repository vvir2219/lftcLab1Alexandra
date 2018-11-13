package com.company;

import tables.CodeTable;
import tables.ElementIPF;
import tables.IPFTable;
import tables.SymbolTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Analizator {

    private String filename;
    private CodeTable codeTable;
    private SymbolTable symbolTable;
    private IPFTable ipfTable;
    private List<CodeError> codeErrors;
    private TokenMatcher codeTableMatcher;
    private TokenMatcher integerMatcher;

    private TokenMatcher identifierMatcher;
    private TokenMatcher doubleMatcher;

    public Analizator(String filename) {
        this.filename = filename;
        codeTable = new CodeTable();
        symbolTable = new SymbolTable();
        ipfTable = new IPFTable();
        codeTableMatcher = new CodeTableMatcher(codeTable);
        integerMatcher = new IntegerMatcher();

        identifierMatcher  = new IdentifierMatcher();
        doubleMatcher = new DoubleMatcher();

    }

    public void analize() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line;
        Integer lineNumber  = 0;

        while ((line = bufferedReader.readLine()) != null) {
            {
                StringIterator iterator = new StringIterator(line);
                while (iterator.valid()) {
                    skipWhitespace(iterator);

                    Match match = doubleMatcher.match(iterator);
                    if (match.isValid())
                    {
                        System.out.println(match.getValue() + " = " + match.getToken().get());
                        symbolTable.addSymbol(match.getValue());
                        ipfTable.addElementIPF(new ElementIPF(codeTable.getCode("constant"),symbolTable.getSymbolCode(match.getValue())));
                    }
                    else {
                        match = integerMatcher.match(iterator);
                        if (match.isValid())
                        {
                            System.out.println(match.getValue() + " = " + match.getToken().get());
                            symbolTable.addSymbol(match.getValue());
                            ipfTable.addElementIPF(new ElementIPF(codeTable.getCode("constant"),symbolTable.getSymbolCode(match.getValue())));
                        }
                        else {
                                match = codeTableMatcher.match(iterator);
                                if (match.isValid())
                                {
                                    System.out.println(match.getValue() + " = " + match.getToken().get());
                                    ipfTable.addElementIPF(new ElementIPF(codeTable.getCode(match.getValue()),null));
                                }
                                else {
                                    match = identifierMatcher.match(iterator);
                                    if (match.isValid())
                                    {
                                        System.out.println(match.getValue() + " = " + match.getToken().get());
                                        symbolTable.addSymbol(match.getValue());
                                        ipfTable.addElementIPF(new ElementIPF(codeTable.getCode("identifier"),symbolTable.getSymbolCode(match.getValue())));
                                    }
                                    else {
                                        System.out.println("eroare la linia : " + lineNumber);
                                        break;
                                    }
                                }
                             }
                        }


                    }
                }
                lineNumber++;
            }


        }

        public void printIPFTable()
        {
            for(ElementIPF e : ipfTable.getElementsIPF())
            {
                System.out.println(e.getCodeTableCode() + " " + e.getSymbolTableCode());
            }
            System.out.println();
        }

        public void printSymbolTable()
        {
            symbolTable.printSymbolTable();
            System.out.println();
        }

    private void skipWhitespace(StringIterator iterator) {
        while (Character.isWhitespace(iterator.current()))
            iterator.next();
    }
}
