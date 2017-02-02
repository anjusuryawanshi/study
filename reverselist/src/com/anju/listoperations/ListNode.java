package com.anju.listoperations;

/**
 * Created by mystique on 7/4/15.
 */
public class ListNode {
    char data;
    ListNode next;
    public ListNode(char data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }

    public char getData() {
        return this.data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
