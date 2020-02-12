// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.
// See: https://leetcode.com/problems/merge-two-sorted-lists/

// TODO: The problem can be done with O(1) space complexity

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.*;

import com.leetcode.linked_list.util.ListNode;

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
        ListNode l1 = initList(1, 2, 4);
        ListNode l2 = initList(1, 3, 4);

        printLinkedList(sln.mergeTwoLists(l1, l2));
    }
}
