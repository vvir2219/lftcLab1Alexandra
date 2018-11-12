package tables;

import java.util.Map;

public class SymbolTable {

    private Map<String,Integer> st;

    public void addSymbol(String symbol)
    {
        Integer size = st.size();
        st.put(symbol,size);
    }

    public Integer getSymbolCode(String symbol)
    {
        return st.get(symbol);
    }

    public Map<String, Integer> getSt() {
        return st;
    }

}
