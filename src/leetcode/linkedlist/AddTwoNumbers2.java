// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
// See: https://leetcode.com/problems/add-two-numbers-ii/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import leetcode.util.linkedlist.ListNode;

public class AddTwoNumbers2 {

    /* Working and fast solution but not elegant. 
     * It just assembles two solutions: @AddTwoNumbers and @ReverseLinkedList
     * TODO: What if the reversing the lost is not allowed?
     * One possible way is to to use two stacks but it seems ugly for me.
     */
    // Solution 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
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
        
        if (reminder > 0)
            head.next = new ListNode(reminder);
        
        return reverseList(result.next);
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;    
        
        ListNode curr = reverseList(head.next);
        head.next.next = head;;
        head.next = null;

        return curr;
    }
    
    // Solution 2
    // This solution not work because of the int/long overflow error
    public ListNode addTwoNumbers_var1(ListNode l1, ListNode l2) {
        long num = toNum(l1) + toNum(l2);
        if (num == 0) 
            return new ListNode(0);
        ListNode head = null;
        while (num > 0) {
            ListNode curr = new ListNode((int)(num % 10));
            curr.next = head;
            head = curr;
            num /= 10;
        }
        return head;
    }
    private long toNum(ListNode head) {
        long res = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            res = res * 10 + curr.val;
        return res;
    }
    
    public static void main(String[] args) {
        AddTwoNumbers2 sln = new AddTwoNumbers2();
        ListNode l1 = initList(3, 9, 9, 9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = initList(7);
        
        printLinkedList(sln.addTwoNumbers(l1, l2));

    }

}
