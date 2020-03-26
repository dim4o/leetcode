// Given a linked list and a value x, partition it such that all nodes 
// less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
// See: https://leetcode.com/problems/partition-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

public class PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        head = tmp;
        
        ListNode dummy = head;
        while (head != null && head.next != null && head.next.val < x)
            head = head.next;

        ListNode fast = head;

        while (fast != null && fast.next != null )
            if (fast.next.val < x) {
                ListNode nextNode = head.next;
                head.next = new ListNode(fast.next.val);
                head.next.next = nextNode;
                head = head.next;
                fast.next = fast.next.next;
            } else 
                fast = fast.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        PartitionList sln = new PartitionList();
        
        printLinkedList(sln.partition(initList(1, 4, 3, 2, 5, 2), 3)); // 1 -> 2 -> 2 -> 4 -> 3 -> 5
        
        printLinkedList(sln.partition(initList(1), 0)); // 1

        printLinkedList(sln.partition(initList(3, 1), 3)); // 1 -> 3
        
        printLinkedList(sln.partition(initList(1, 2, 3), 4)); // 1 -> 2 -> 3
    }

}
