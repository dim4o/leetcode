// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) 
// in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
// Note: Do not modify the linked list.
// See: https://leetcode.com/problems/linked-list-cycle-ii/

package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.linkedlist.ListNode;

public class LinkedListCycle2 {
    // TODO: Solve the problem  without using extra space.
    // Try to use a similar this approach for cycle detection:
    // https://leetcode.com/problems/find-the-duplicate-number/solution/

    /**
     * O(n) time, O(n) space.
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            
            set.add(head);
            head = head.next;
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
