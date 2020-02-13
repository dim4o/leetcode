// Given a linked list, swap every two adjacent nodes and return its head.
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// See: https://leetcode.com/problems/swap-nodes-in-pairs/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;
import static com.leetcode.linked_list.util.LinkedListUtil.printLinkedList;

import com.leetcode.linked_list.util.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1); // some dummy value
        ListNode first = head;
        prev.next = first;
        ListNode second = head.next;
        ListNode res = second;

        while (first.next != null) {
            prev.next = first.next;
            first.next = first.next.next;
            second.next = first;

            if (first.next != null) {
                prev = first;
                first = first.next;
                second = first.next;
            }
        }

        return res;
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
