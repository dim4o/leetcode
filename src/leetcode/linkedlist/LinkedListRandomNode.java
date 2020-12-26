

package leetcode.linkedlist;

import leetcode.util.linkedlist.ListNode;

import java.util.Random;

public class LinkedListRandomNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * Stupid brute-force without time optimization
     * The advantage of this solution is the O(1) memory
     * TODO: Implement Reservoir Sampling algorithm solution
     */
    class Solution {
        private ListNode head;
        private int size = 1;
        private Random rnd;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            this.rnd = new Random();
            while ((head = head.next) != null) size++;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int idx = rnd.nextInt(size);
            ListNode curr = head;
            for (int i = 0; i < idx; curr = curr.next, i++) { }

            return curr.val;
        }
    }

    public static void main(String[] args) {

    }
}
