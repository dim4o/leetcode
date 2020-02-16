// Given a linked list, rotate the list to the right by k places, where k is non-negative.
// See: https://leetcode.com/problems/rotate-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import leetcode.util.linkedlist.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) 
            return head;
        ListNode oldTail = head;
        ListNode newTail = head;
        int n = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }
        
        int len = k % n;
        
        if (len == 0) {
            return head;
        }

        for (int i = 0; i < n - len - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        oldTail.next = head;
        newTail.next = null;
        
        return newHead;
    }

    public static void main(String[] args) {
        RotateList sln = new RotateList();
        
        ListNode l0 = initList(1, 2, 3, 4, 5);
        printLinkedList(sln.rotateRight(l0, 2)); // 1->2->3->4->5->NULL

        ListNode l1 = initList(1, 2, 3, 4, 5);
        printLinkedList(sln.rotateRight(l1, 10)); // 5->1->2->3->4->NULL

        ListNode l2 = initList(0, 1, 2);
        printLinkedList(sln.rotateRight(l2, 4)); // 2->0->1->NULL
        
        ListNode l3 = initList(1);
        printLinkedList(sln.rotateRight(l3, 1)); // 1->NULL
        
        ListNode l4 = initList(1, 2);
        printLinkedList(sln.rotateRight(l4, 1)); // 2->1->NULL
    }

}
