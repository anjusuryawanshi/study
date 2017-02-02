package iterator;

/**
 * Created by mystique on 12/5/16.
 */
public interface Iterator<E> {

    /**
     * returns true if the iteration has more elements (if next() would return
     * an element rather than throwing an exception.
     * @return true if the iteration has more elements
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     * @return the next element(E) in the iteration
     * @throws java.util.NoSuchElementException
     */
    E next();

    /**
     * Removes the last element returned by iterator of an underlying collection.
     * This method can be called once per call to next(). The behavior of the iterator
     * is unspecified if the underlying collection is modified while the iteration is in
     * progress in any way other than calling this method.
     * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
     * @throws IllegalStateException if the next method has not been yet called or if the remove
     * method has already been called after the last call to the next()
     *
     */
    void remove();
}
