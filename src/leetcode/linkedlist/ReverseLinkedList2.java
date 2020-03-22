// Reverse a linked list from position m to n. Do it in one-pass.
// Note: 1 ≤ m ≤ n ≤ length of list.
// See: https://leetcode.com/problems/reverse-linked-list-ii/
// TODO: Add recursive solution

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

public class ReverseLinkedList2 {
    
    /**
     * Iterative solution.
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode originHead = head;
        ListNode leftPartTail = null;
        for (int i = 0; i < m - 1; i++) {
            leftPartTail = head;
            head = head.next;
        }
        
        ListNode prev = null;
        ListNode revsedPartTail = head;

        for (int i = m; i < n + 1; i++) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        ListNode reversedPartHead = prev;
        
        if (leftPartTail == null) {
            revsedPartTail.next = head;
            return reversedPartHead;
        }
        
        leftPartTail.next = reversedPartHead;
        revsedPartTail.next = head;
        
        return originHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList2 sln = new ReverseLinkedList2();
        ListNode list = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printLinkedList(list);
        
        ListNode rev = sln.reverseBetween(list, 1, 5);
        printLinkedList(rev);

    }

}
