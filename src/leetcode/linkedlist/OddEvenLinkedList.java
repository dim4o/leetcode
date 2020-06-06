// Given a singly linked list, group all odd nodes together followed by the even nodes. 
// Please note here we are talking about the node number and not the value in the nodes.
// You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
// See: https://leetcode.com/problems/odd-even-linked-list/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import leetcode.util.linkedlist.ListNode;

public class OddEvenLinkedList {
    /**
     * O(n) time, O(1) space.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode evenTail = head;
        ListNode oddTail = head.next;
        ListNode oddHead = oddTail;
        
        while (evenTail.next != null && oddTail.next != null) {
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
            oddTail.next = oddTail.next.next;
            oddTail = oddTail.next;
        }
        
        evenTail.next = oddHead;
        
        return head;
    }
    public static void main(String[] args) {
        OddEvenLinkedList sln = new OddEvenLinkedList();
        printLinkedList(sln.oddEvenList(initList()));
        printLinkedList(sln.oddEvenList(initList(1)));
        printLinkedList(sln.oddEvenList(initList(1, 2)));
        printLinkedList(sln.oddEvenList(initList(1, 2, 3, 4, 5, 6)));
        printLinkedList(sln.oddEvenList(initList(1, 2, 3, 4, 5, 6, 7)));
    }

}
