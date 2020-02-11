// Given a sorted linked list, delete all duplicates such that each element appear only once.
// See: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package com.leetcode.linked_list;

import com.leetcode.linked_list.util.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy_head = head;
        while (head != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        
        return dummy_head;
    }

    public static void main(String... args) {
        RemoveDuplicatesFromSortedList sln = new RemoveDuplicatesFromSortedList();
        ListNode n1_1 = new ListNode(1);
        ListNode n1_2 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3_1 = new ListNode(3);
        ListNode n3_2 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1_1.next = n1_2;
        n1_2.next = n2;
        n2.next = n3_1;
        n3_1.next = n3_2;
        n3_2.next = n4;
        
        ListNode res1 = sln.deleteDuplicates(n1_1);
        sln.printList(res1);
        System.out.println("----------");

        ListNode n42 = new ListNode(42);
        ListNode res2 = sln.deleteDuplicates(n42);
        sln.printList(res2);
        System.out.println("----------");

        ListNode res3 = sln.deleteDuplicates(null);
        sln.printList(res3);
        System.out.println("----------");
        
        ListNode nn1_1 = new ListNode(1);
        ListNode nn1_2 = new ListNode(1);
        ListNode nn1_3 = new ListNode(1);
        ListNode nn1_4 = new ListNode(2);
        nn1_1.next = nn1_2;
        nn1_2.next = nn1_3;
        nn1_3.next = nn1_4;
        ListNode res4 = sln.deleteDuplicates(nn1_1);
        sln.printList(res4);
    }
    
    private void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
