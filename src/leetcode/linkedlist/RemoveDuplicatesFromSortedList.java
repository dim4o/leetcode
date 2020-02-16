// Given a sorted linked list, delete all duplicates such that each element appear only once.
// See: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

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
        ListNode res1 = sln.deleteDuplicates(initList(1, 1, 2, 3, 3, 4));
        printLinkedList(res1);

        ListNode res2 = sln.deleteDuplicates(new ListNode(42));
        printLinkedList(res2);

        ListNode res3 = sln.deleteDuplicates(null);
        printLinkedList(res3);
        
        ListNode res4 = sln.deleteDuplicates(initList(1, 1, 1, 2));
        printLinkedList(res4);
    }
}
