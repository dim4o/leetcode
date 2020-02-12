// Given a singly linked list, determine if it is a palindrome.
// See: https://leetcode.com/problems/palindrome-linked-list/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;

import java.util.Stack;

import com.leetcode.linked_list.util.ListNode;

public class PalindromeLinkedList {
    /**
     * The idea is to reverse the first half of the list (in-place),
     * and to compare with the second half
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevNode = null;
        
        // reverse the first half of the linked list        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
        }

        // if the list size is odd -> move the "slow" forward
        // 1->2->3->4->5 (the "slow" pointer will be moved from 3 to 4)
        if (fast != null && fast.next == null)
            slow = slow.next;
        
        // compare the reversed first half with the second half of the linked list
        // "prevNode" is the head of the reversed first half of the linked list
        // "slow" is the head of the second half of the list
        while (prevNode != null && prevNode.val == slow.val) {
            prevNode = prevNode.next;
            slow = slow.next;
        }

        return prevNode == null;
    }

    // Brute-force not optimized solution with stack
    public boolean isPalindrome_bruteforce(ListNode head) {
        if (head == null)
            return true;
        // create a stack with the linked list values
        Stack<Integer> stack = new Stack<>();
        ListNode originHead = head;

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        // create a reversed linked list
        ListNode newHead = new ListNode(stack.pop());
        ListNode reversed = newHead;

        while (!stack.empty()) {
            newHead.next = new ListNode(stack.pop());
            newHead = newHead.next;
        }

        // compare the original with the reversed values
        while (reversed != null) {
            if (reversed.val != originHead.val) {
                return false;
            }
            reversed = reversed.next;
            originHead = originHead.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList sln = new PalindromeLinkedList();
        ListNode n1 = initList(1, 2, 3, 3, 2, 1);

        System.out.println(sln.isPalindrome(n1));
    }
}
