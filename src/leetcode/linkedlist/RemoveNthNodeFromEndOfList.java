// Given a linked list, remove the n-th node from the end of list and return its head.
// See: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        ListNode p1 = dummy_head;
        ListNode p2 = dummy_head;

        for (int i = 1; i <= n + 1; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p2.next = p2.next.next;
        
        return dummy_head.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;
        int size = 0;
        while (p1 != null) {
            p1 = p1.next;
            size++;
        }
        if (n == size) {
            head = head.next;
            return head;
        }
        int curr = 1;

        while (curr != size - n) {
            prev = p2;
            p2 = p2.next;
            curr++;
        }

        prev.next = p2.next;

        return head;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList sln = new RemoveNthNodeFromEndOfList();
        ListNode list = initList(1, 2, 3, 4, 5);
        ListNode res = sln.removeNthFromEnd(list, 1);
        printLinkedList(res);

    }

}
