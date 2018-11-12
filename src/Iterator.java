public interface Iterator<T> {
    boolean valid();
    T current();
    void next();
    void previous();
    void copyFrom(Iterator<T> ot);
}
