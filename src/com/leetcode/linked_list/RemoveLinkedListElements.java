// Remove all elements from a linked list of integers that have value val.
// https://leetcode.com/problems/remove-linked-list-elements/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;
import static com.leetcode.linked_list.util.LinkedListUtil.printLinkedList;

import com.leetcode.linked_list.util.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode result = head;
        ListNode prev = head;
        if (head == null)
            return null;
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

        int[] values = new int[] {1, 6, 6, 1, 5, 6};
        printLinkedList(initList(values));
        printLinkedList(sln.removeElements(initList(values), 6));
        printLinkedList(sln.removeElements(initList(values), 1));
    }
}
