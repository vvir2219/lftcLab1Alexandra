package tables;

public class ElementIPF {

    private Integer codeTableCode;
    private Integer symbolTableCode;

    public ElementIPF(Integer codeTableCode, Integer symbolTableCode) {
        this.codeTableCode = codeTableCode;
        this.symbolTableCode = symbolTableCode;
    }

    public Integer getCodeTableCode() {
        return codeTableCode;
    }

    public Integer getSymbolTableCode() {
        return symbolTableCode;
    }
}
