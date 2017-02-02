package com.anju.listoperations;

public class LinkedListSwap {
    public static void main(String[] args) {
        ListNode head = new ListNode('A', new ListNode('B', new ListNode('C', new ListNode('D', null))));

        head = swapList(head);
        while(head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }

    }

    public static ListNode swapList(ListNode head) {

        if (head == null) {
            return null;
        }
        if(head.next != null) {
            swap(head, head.next);
        }
        return head;

    }

    private static void swap(ListNode head, ListNode next) {
        ListNode curr = head.next;
        curr.next = head;
        head.next = curr.next.next;
    }
}
