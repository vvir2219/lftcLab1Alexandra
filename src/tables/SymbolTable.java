package tables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SymbolTable {

    private Map<String,Integer> st = new HashMap<>();

    public void addSymbol(String symbol)
    {
        Integer size;



        if (st == null)
            size = 0;
        else
            size = st.size();

        st.put(symbol,size);
    }

    public Integer getSymbolCode(String symbol)
    {
        return st.get(symbol);
    }

    public Map<String, Integer> getSt() {
        return st;
    }

    public void printSymbolTable()
    {
        Iterator<Map.Entry<String, Integer>> it = st.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
    }


}
