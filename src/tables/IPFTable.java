package tables;

import java.util.ArrayList;
import java.util.List;

public class IPFTable {

    private ArrayList<ElementIPF> elementsIPF = new ArrayList<>();

    public void addElementIPF(ElementIPF elementIPF)
    {
        elementsIPF.add(elementIPF);
    }

    public List<ElementIPF> getElementsIPF() {
        return elementsIPF;
    }
}
