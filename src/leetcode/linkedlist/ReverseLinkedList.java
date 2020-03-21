// Reverse a singly linked list.
// A linked list can be reversed either iteratively or recursively. Could you implement both?
// See: https://leetcode.com/problems/reverse-linked-list/
// My solution at leetcode: https://leetcode.com/problems/reverse-linked-list/discuss/546673/Java-Another-Recursive-Approach

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import leetcode.util.linkedlist.ListNode;

public class ReverseLinkedList {

    /**
     * Recursive solution.
     * Great explanation here: https://www.youtube.com/watch?time_continue=4&v=MRe3UsRadKw&feature=emb_logo
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;    
        
        ListNode curr = reverseList(head.next);

        head.next.next = head;;
        head.next = null;

        return curr;
    }

    /**
     * Recursive solution.
     * See: https://leetcode.com/problems/reverse-linked-list/discuss/546673/Java-Another-Recursive-Approach
     */
    public ListNode reverseList_var3(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode reversedpart, ListNode curr) {
        if (curr == null)
            return reversedpart;

        ListNode nextNode = curr.next;
        curr.next = reversedpart;

        return reverse(curr, nextNode);
    }

    public ListNode reverseList_var2(ListNode head) {
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
