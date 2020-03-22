// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// See: https://leetcode.com/problems/reorder-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

public class ReorderList {
    
    public void reorderList(ListNode head) {
        // find the mid point
        ListNode fast = head, mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        
        // reverse the second half
        ListNode prev = null;
        ListNode curr = mid;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // reorder the list
        ListNode currNode = head;
        while (prev != null) {
            ListNode nextNode = currNode.next;
            ListNode nextNodeRev = prev.next;
            
            currNode.next = prev;
            prev.next = nextNode;
            
            currNode = nextNode;
            prev = nextNodeRev;
        }
        
        if (currNode != null) currNode.next = null;
    }

    public static void main(String[] args) {
        ReorderList sln = new ReorderList();
        ListNode l1 = initList(1, 2, 3, 4 ,5);
        ListNode l2 = initList(1, 2, 3, 4 ,5, 6);
        ListNode l3 = initList(1, 2, 3);
        
        sln.reorderList(l1);
        printLinkedList(l1);
        
        sln.reorderList(l2);
        printLinkedList(l2);
        
        sln.reorderList(l3);
        printLinkedList(l3);
    }

}
