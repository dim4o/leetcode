// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
// See: https://leetcode.com/problems/delete-node-in-a-linked-list/

package com.leetcode.linked_list;

import static com.leetcode.linked_list.util.LinkedListUtil.*;

import com.leetcode.linked_list.util.ListNode;

public class DeleteNodeLinkeList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String... args) {
        DeleteNodeLinkeList sln = new DeleteNodeLinkeList();
        ListNode ln = initList(4, 5, 1, 9);
        
        printLinkedList(ln);
        sln.deleteNode(ln.next);
        printLinkedList(ln);
    }
}
