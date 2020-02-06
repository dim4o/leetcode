// Reverse a singly linked list.
// See: https://leetcode.com/problems/reverse-linked-list/

// TODO: A linked list can be reversed either iteratively or recursively. Could you implement both?

package com.leetcode.linked_list;

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
        
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode reversed = sln.reverseList(n1);
        sln.printList(reversed);
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
