// Reverse a singly linked list.
// See: https://leetcode.com/problems/reverse-linked-list/

// TODO: A linked list can be reversed either iteratively or recursively. Could you implement both?

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.initList;
import static com.leetcode.linked_list.util.LinkedListUtil.printLinkedList;

import com.leetcode.linked_list.util.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
    
    public ListNode reverseList_var1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        
        while (nextNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;            
        }
        
        currNode.next = prevNode;
        
        return currNode;
    }

    public static void main(String... args) {
        ReverseLinkedList sln = new ReverseLinkedList();
        
        ListNode n = initList(1, 2, 3, 4);
        ListNode reversed = sln.reverseList(n);
        printLinkedList(reversed);
    }
}
