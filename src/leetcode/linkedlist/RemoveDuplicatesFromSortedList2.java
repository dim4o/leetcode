// Given a sorted linked list, delete all nodes that have duplicate numbers, 
// leaving only distinct numbers from the original list.
// Return the linked list sorted as well.
// See: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.linkedlist.ListNode;


public class RemoveDuplicatesFromSortedList2 {
    /**
     * Initial solution with HashMap.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ans.next = head;

        Set<Integer> freqMap = new HashSet<>();
        for (ListNode i = head; i != null; i = i.next)
            if (i.next != null && i.val == i.next.val)
                freqMap.add(i.val);

        ListNode prev = null;
        for (ListNode i = ans; i != null; i = i.next)
            if (freqMap.contains(i.val))
                prev.next = i.next;
            else
                prev = i;

        return ans.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 sln = new RemoveDuplicatesFromSortedList2();
        printLinkedList(sln.deleteDuplicates(initList(1, 2, 3, 3, 4, 4, 5)));
        printLinkedList(sln.deleteDuplicates(initList(1, 1, 1, 2, 3)));
        printLinkedList(sln.deleteDuplicates(initList(0, 0, 0)));
    }

}
