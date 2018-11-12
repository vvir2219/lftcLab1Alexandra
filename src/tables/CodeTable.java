package tables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CodeTable {

    private Map<String,Integer> ct = new HashMap<String, Integer>();

    public CodeTable()
    {
        addCodesForAtoms();
    }

    public void addCode(String symbol)
    {
        Integer size;
        //System.out.println(ct.size());
        if (ct == null)
            size = 0;
        else
            size = ct.size();
        ct.put(symbol,size);
    }

    private void addCodesForAtoms() {

        addCode("identifier");
        addCode("constant");
        addCode("const");
        addCode("int");
        addCode("double");
        addCode("char");
        addCode("bool");
        addCode("read_STDIN");
        addCode("write_STDIN");
        addCode("while");
        addCode("if");
        addCode("else");
        addCode("+");
        addCode("-");
        addCode("/");
        addCode("*");
        addCode("=");
        addCode("==");
        addCode("!=");
        addCode("<");
        addCode(">");
        addCode("<=");
        addCode(">=");
        addCode("&&");
        addCode("||");
        addCode("{");
        addCode("}");
        addCode("[");
        addCode("]");
        addCode("(");
        addCode(")");
        addCode(";");
        addCode(",");
    }

    public Integer getCode (String symbol)
    {

        return ct.get(symbol);
    }

    public Integer numberOfMatches(String code)
    {
        Integer matchesFound = 0;
        Iterator<Map.Entry<String, Integer>> it = ct.entrySet().iterator();

        for (Map.Entry<String, Integer> el: ct.entrySet()) {
            if(el.getKey().startsWith(code))
                matchesFound++;
        }

        return matchesFound;
    }

}
