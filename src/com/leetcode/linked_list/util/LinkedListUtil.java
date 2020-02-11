package com.leetcode.linked_list.util;

public class LinkedListUtil {
    public static ListNode initList(int... values) {
        ListNode head = new ListNode(0);
        ListNode dummy_head = head;
        for (int value : values) {
            dummy_head.next = new ListNode(value);
            dummy_head = dummy_head.next;
        }

        return head.next;
    }

    public static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);

            head = head.next;
            if (head != null) {
               sb.append(" -> ");
            }
        }

        System.out.println(sb.toString());
    }
}
