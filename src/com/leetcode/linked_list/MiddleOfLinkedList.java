// Given a non-empty, singly linked list with head node head, return a middle node of linked list.
// If there are two middle nodes, return the second middle node.
// See: https://leetcode.com/problems/middle-of-the-linked-list/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;

import com.leetcode.linked_list.util.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList sln = new MiddleOfLinkedList();

        System.out.println(sln.middleNode(initList(1, 2, 3, 4, 5, 6)).val);
    }
}
