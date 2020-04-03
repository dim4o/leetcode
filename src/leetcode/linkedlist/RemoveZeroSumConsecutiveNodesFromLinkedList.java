// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes 
// that sum to 0 until there are no such sequences.
// After doing so, return the head of the final linked list.  You may return any such answer.
// See: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import leetcode.util.linkedlist.ListNode;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    
    // TODO: try to optimize the solution
    private boolean remove = false;
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode curr = head;
        while (true) {
            remove = false;
            curr = helper(curr);
            if (curr == null || remove == false)
                break;
        }
        return curr;
    }

    public ListNode helper(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        Map<Integer, LinkedList<ListNode>> map = new HashMap<>();
        int currSum = 0;
        for (ListNode i = res; i != null; i = i.next) {
            currSum += i.val;
            map.computeIfAbsent(currSum, k -> new LinkedList<>()).add(i);
        }

        for (Integer sum : map.keySet()) {
            if (map.get(sum).size() > 1) {
                remove = true;
                LinkedList<ListNode> curr = map.get(sum);
                curr.getFirst().next = curr.getLast().next;
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesFromLinkedList sln = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        printLinkedList(sln.removeZeroSumSublists(initList(1, 2, -3, 3, 1)));
        printLinkedList(sln.removeZeroSumSublists(initList(1, 2, 3, -3, 4)));
        printLinkedList(sln.removeZeroSumSublists(initList(1, 2, 3, -3, -2)));
        printLinkedList(sln.removeZeroSumSublists(initList(-1, 1)));
        printLinkedList(sln.removeZeroSumSublists(initList(0, 2)));
        printLinkedList(sln.removeZeroSumSublists(initList(1, 3, 2, -3, -2, 5, 5, -5, 1)));
    }

}
