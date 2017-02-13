import java.util.NoSuchElementException;

public class LinkedList<T> {
  int size = 0;
  protected int modCount = 0;
  Node<T> head = new Node<T>(null, null, null);

  public LinkedList() {
    head.next = head.prev = head;
  }


  public boolean add(T data) {
    addBefore(data, head);
    return true;
  }

  private Node<T> addBefore(T data, Node<T> node) {
    Node<T> newEntry = new Node<T>(data, node, node);
    newEntry.prev.next = newEntry;
    newEntry.next.prev = newEntry;
    size++;
    modCount++;
    return newEntry;
  }

  public void add(int index, T data) {
    if (index == 0) {
      addFirst(data);
    }
    if (index > 0) {
      Node<T> temp = head.next;
      for (int i = 0; i <= index; i++) {
        temp = temp.next;
      }
      addBefore(data, temp);
    }
  }

  public void addFirst(T data) {

  }

  public T getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return head.next.data;
  }

  public T getLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return head.prev.data;
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
