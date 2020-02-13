// Write a program to find the node at which the intersection of two singly linked lists begins.
// See: https://leetcode.com/problems/intersection-of-two-linked-lists/
// TODO: Can you solve the problem with N(1) space complexity?

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;
import static com.leetcode.linked_list.util.LinkedListUtil.printLinkedList;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.linked_list.util.ListNode;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode dummyHeadA = headA;
        ListNode dummyHeadB = headB;
        while (dummyHeadA != null) {
            set.add(dummyHeadA);
            dummyHeadA = dummyHeadA.next;
        }
        while (dummyHeadB != null) {
            if (set.contains(dummyHeadB)) {
                return dummyHeadB;
            }
            dummyHeadB = dummyHeadB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements sln = new RemoveLinkedListElements();

        int[] values = new int[] { 1, 6, 6, 1, 5, 6 };
        printLinkedList(initList(values));
        printLinkedList(sln.removeElements(initList(values), 6));
        printLinkedList(sln.removeElements(initList(values), 1));
    }
}
