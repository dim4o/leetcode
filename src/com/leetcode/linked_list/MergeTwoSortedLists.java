// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.
// See: https://leetcode.com/problems/merge-two-sorted-lists/

// TODO: The problem can be done with O(1) space complexity

package com.leetcode.linked_list;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        head.next = l1 != null ? l1 : l2; // tail nodes
        
        return result.next;
    }


    public static void main(String[] args) {
        MergeTwoSortedLists sln = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode.printLinkedList(sln.mergeTwoLists(l1, l2));
    }
}
