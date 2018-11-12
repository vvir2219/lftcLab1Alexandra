import javax.xml.bind.ValidationException;

public class StringIterator implements Iterator<Character> {
    private String source;
    private int index;

    public StringIterator(String string) {
        source = string;
        index = 0;
    }

    public StringIterator(StringIterator ot) {
        source = ot.source;
        index = ot.index;
    }

    @Override
    public boolean valid() {
        return index < source.length() && index >= 0;
    }

    @Override
    public Character current() {
        if (!valid())
            return null;

        return source.charAt(index);
    }

    @Override
    public void next() {
        if (!valid())
            return;

        ++index;
    }

    @Override
    public void previous() {
        if (index == 0)
            throw new IndexOutOfBoundsException("Ati ajuns la inceputul sirului de caractere");

        --index;
    }

    @Override
    public void copyFrom(Iterator<Character> ot) {
        this.source = ((StringIterator)ot).source;
        this.index = ((StringIterator)ot).index;
    }
}
