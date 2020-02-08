// Given a singly linked list, determine if it is a palindrome.
// See: https://leetcode.com/problems/palindrome-linked-list/

package com.leetcode.linked_list;

import java.util.Stack;

public class PalindromeLinkedList {
    
    // The idea is to reverse the first half of the list (in-place),
    // and to compare with the second half
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevNode = null;
        ListNode currNode = head;
        
        
        return false;
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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(sln.isPalindrome(n1));
        sln.printList(n1);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
