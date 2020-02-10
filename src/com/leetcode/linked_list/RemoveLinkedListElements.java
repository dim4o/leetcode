// Remove all elements from a linked list of integers that have value val.
// https://leetcode.com/problems/remove-linked-list-elements/

package com.leetcode.linked_list;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode result = head;
        ListNode prev = head;
        if (head == null) return null;
        head = head.next;
        
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements sln = new RemoveLinkedListElements();

        ListNode.printLinkedList(initList());
        ListNode.printLinkedList(sln.removeElements(initList(), 6));
        ListNode.printLinkedList(sln.removeElements(initList(), 1));
    }
    
    private static ListNode initList() {
        ListNode ll = new ListNode(1);
        
        ll.next = new ListNode(1);
        ll.next.next = new ListNode(6);
        ll.next.next.next = new ListNode(6);
        ll.next.next.next.next = new ListNode(1);
        ll.next.next.next.next.next = new ListNode(5);
        ll.next.next.next.next.next.next = new ListNode(6);
        
        return ll;
    }
}
