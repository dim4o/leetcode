// Given a linked list, determine if it has a cycle in it.
// See: https://leetcode.com/problems/linked-list-cycle/

package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.linkedlist.ListNode;

public class LinkedListCycle {
        // O(n) time complexity
        // O(1) space complexity
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                if (fast.next == null) {
                    break;
                } 
                fast = fast.next.next;
                if (fast == slow) {
                    return true;
                }
                slow = slow.next;
            }
            
            return false;
        }

        // O(n) time complexity
        // O(n) space complexity
        public boolean hasCycleVar(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return false;
                }
                set.add(head);
                head = head.next;
            }
            
            return true;
        }
    
    public static void main(String... args) {
        LinkedListCycle sln = new LinkedListCycle();
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        n3.next = n2;
        n2.next = n0;
        n0.next = n1;
        n1.next = n2;
        
        System.out.println(sln.hasCycle(n3));
    }
}
