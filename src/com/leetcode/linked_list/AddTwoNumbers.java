// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// See: https://leetcode.com/problems/add-two-numbers/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.*;

import com.leetcode.linked_list.util.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int reminder = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + reminder;
            head.next = new ListNode(sum % 10);
            reminder = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            head = head.next;
        }
        
        if (reminder > 0) {
            head.next = new ListNode(reminder);
        }
        
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers sln = new AddTwoNumbers();
        
        ListNode res1 = sln.addTwoNumbers(initList(2, 4, 3), initList(5, 6, 4));
        printLinkedList(res1); // 342 + 465 = 807.
        
        ListNode res2 = sln.addTwoNumbers(initList(2, 4, 3), initList(5, 6, 4, 1));
        printLinkedList(res2); // 342 + 1465 = 1807.
        
        ListNode res3 = sln.addTwoNumbers(initList(5), initList(5));
        printLinkedList(res3); // 5 + 5 = 10.
        
        ListNode res4 = sln.addTwoNumbers(initList(1), initList(9, 9));
        printLinkedList(res4); // 1 + 99 = 100.
    }

}
