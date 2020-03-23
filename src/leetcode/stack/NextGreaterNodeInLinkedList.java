// We are given a linked list with head as the first node.  
// Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
// Return an array of integers answer, 
// where answer[i] = next_larger(node_{i+1}).
// See: https://leetcode.com/problems/next-greater-node-in-linked-list/

package leetcode.stack;

import static leetcode.util.linkedlist.LinkedListUtil.*;

import java.util.Arrays;
import java.util.Stack;

import leetcode.util.linkedlist.ListNode;

public class NextGreaterNodeInLinkedList {

    /**
     * O(n) time, O(n) space.
     */
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (head != null) {
            head = head.next;
            n++;
        }
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        while (curr != null) {
            while (!stack.empty() && curr.val > stack.peek()[0])
                ans[stack.pop()[1]] = curr.val;
            stack.add(new int[] { curr.val, i++ });
            curr = curr.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList sln = new NextGreaterNodeInLinkedList();
        ListNode head1 = initList(1, 7, 5, 1, 9, 2, 5, 1);
        ListNode head2 = initList(2, 7, 4, 3, 5);
        ListNode head3 = initList(2, 1, 5);

        System.out.println(Arrays.toString(sln.nextLargerNodes(head1)));
        System.out.println(Arrays.toString(sln.nextLargerNodes(head2)));
        System.out.println(Arrays.toString(sln.nextLargerNodes(head3)));
    }

}
