package list;

public interface List<E> extends Iterable<E> {
    void add(E e);
    int size();
    E get(int index);
    boolean contains(E e);
    boolean isEmpty();
    void remove(int index);
    default boolean isNotEmpty() {
        return !isEmpty();
    }
}
