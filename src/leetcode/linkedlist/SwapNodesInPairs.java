// Given a linked list, swap every two adjacent nodes and return its head.
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// See: https://leetcode.com/problems/swap-nodes-in-pairs/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import leetcode.util.linkedlist.ListNode;

public class SwapNodesInPairs {
    /**
     * Initial recursive solution.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = swapPairs(head.next.next);
        int tmp = head.val;
        head.val = head.next.val;
        head.next.val = tmp;
        head.next.next = prev;
        
        return head;
    }
    
    /**
     * Another recursive solution with interesting swap.
     */
    public ListNode swapPairs_var2(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode newHead = head.next;
        head.next = swapPairs_var2(newHead.next);
        newHead.next = head;
        
        return newHead;
    }
    
    public ListNode swapPairs_var1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1); // some dummy value
        prev.next = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode res = prev;

        while (first.next != null) {
            // swap first and second node
            prev.next = first.next;
            first.next = first.next.next;
            second.next = first;
            
            if (first.next != null) {
                // reassign the first and second node to next pair
                prev = first;
                first = first.next;
                second = first.next;
            }
        }

        return res.next;
    }

    public static void main(String... args) {
        SwapNodesInPairs sln = new SwapNodesInPairs();

        ListNode n = initList(1, 2, 3, 4);
        ListNode swaped = sln.swapPairs(n);
        printLinkedList(swaped);
        printLinkedList(sln.swapPairs(initList(1, 2, 3, 4, 5, 6)));
        printLinkedList(sln.swapPairs(initList(1, 2, 3, 4, 5, 6, 7)));
        printLinkedList(sln.swapPairs(initList(1, 2)));
        printLinkedList(sln.swapPairs(initList(1)));
        printLinkedList(sln.swapPairs(initList()));
    }
}
