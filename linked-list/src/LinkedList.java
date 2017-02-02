import java.util.NoSuchElementException;

public class LinkedList<T> {
  int size = 0;
  Node<T> head = new Node<T>(null, null, null);

  public LinkedList() {
    head.next = head.prev = head;
  }


  public boolean add(T data) {
    return false;
  }

  public void add(int index, T data) {

  }

  public void addFirst(T data) {

  }

  public T getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return head.next.data;
  }

  public Node<T> getLast() {
    return null;
  }

  public int size() {
    return size;
  }

  public T remove() {
    return null;
  }
  public T remove(T data) {
    return null;
  }

  public T remove(int index) {
    return null;
  }

  public T set(int index, T data) {
    return null;
  }
}

class Node<T> {
  T data;
  Node<T> next;
  Node<T> prev;
  Node(T data, Node<T> next, Node<T> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }
}
