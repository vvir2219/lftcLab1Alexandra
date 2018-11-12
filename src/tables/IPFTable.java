package tables;

import java.util.List;

public class IPFTable {

    private List<ElementIPF> elementsIPF;

    public void addElementIPF(ElementIPF elementIPF)
    {
        elementsIPF.add(elementIPF);
    }

    public List<ElementIPF> getElementsIPF() {
        return elementsIPF;
    }
}
