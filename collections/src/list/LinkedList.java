package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> {
    private ListNode<E> head = null;
    private ListNode<E> end = null;
    private int size = 0;

    public E getHead() {
        return this.head.data;
    }

    public E getEnd() {
        return this.end.data;
    }

    @Override
    public void add(E e) {
        ListNode<E> newNode = new ListNode<>(e);
        if (isEmpty()) {
            this.head = this.end = newNode;
            this.head.next = this.end.next = null;
        }
        else {
            this.end.next = newNode;
            this.end = newNode;
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        if (index > size() - 1)  {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> current = head;
        for (int i = 0; i <= index-1; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public boolean contains(E e) {
        ListNode<E> curr = head;
        while (curr != null) {
            if (curr.data == e) {
                return true;
            }
            else
                curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void remove(int index) {
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode<E> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }

    @Override
    public Iterator<E> iterator() {
        final LinkedList<E> linkedList = this;

        return new Iterator<E>() {
            final ListNode<E> first = linkedList.head;
            ListNode<E> curr = null;
            private ListNode<E> lastReturned = null;

            @Override
            public boolean hasNext() {
                if(linkedList.isEmpty()) {
                    return false;
                }
                else if(curr == null) {
                    return true;
                }
                else if(curr == linkedList.end) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if(linkedList.isEmpty()) {
                    throw new NoSuchElementException();
                }
                else if (curr == null) {
                    this.curr = first;
                    return curr.data;
                }
                else if (curr.next == null) {
                    throw new NoSuchElementException();
                }
                this.curr = curr.next;
                lastReturned = curr;
                return lastReturned.data;
            }
        };
    }

    private final class ListNode<E> {
        E data;
        ListNode<E> next;

        public ListNode(E data) {
            this.data = data;
        }
        public void setNext(ListNode<E> next) {
            this.next = next;
        }
        public ListNode<E> getNext() {
            return this.next;
        }
    }
}
