package com.leetcode.linked_list;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);

            head = head.next;
            if (head != null) {
               sb.append(" -> ");
            }
        }
        System.err.println(sb.toString());
    }
}
