// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// See: https://leetcode.com/problems/merge-k-sorted-lists/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.util.linkedlist.ListNode;

public class MergeKsortedLists {
    /**
     * Priority Queue (Heap) solution.
     * O(n.log(k)) time.
     * O(n) space.
     * k - the number of the lists.
     * n - the length of the output list (sum of the lengths of all k lists).
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode list : lists)
            if (list != null) pq.add(list);
            
        while (!pq.isEmpty()) {
            ListNode lo = pq.poll();
            head.next = new ListNode(lo.val);
            head = head.next;
            if (lo.next != null) pq.add(lo.next);
        }

        return res.next;
    }

    /**
     * Brute Force solution (accepted).
     */
    public ListNode mergeKLists_var1(ListNode[] lists) {
        List<Integer> resList = new LinkedList<>();
        for (ListNode head : lists)
            for (; head != null; head = head.next)
                resList.add(head.val);
            
        Collections.sort(resList);
        
        ListNode res = new ListNode(-1); 
        ListNode head = res;
        for (int i = 0; i < resList.size(); head = head.next, i++)
            head.next = new ListNode(resList.get(i));
        
        return res.next;
    }
    
    public static void main(String[] args) {
        MergeKsortedLists sln = new MergeKsortedLists();
        
        ListNode[] lists = new ListNode[] {initList(1, 4, 5), initList(1, 3, 4), initList(2, 6)}; 
        
        ListNode res = sln.mergeKLists(lists);
        
        printLinkedList(res);
    }

}
