// Given a (singly) linked list with head node root, write a function to split 
// the linked list into k consecutive linked list "parts".
// The length of each part should be as equal as possible: no two parts should have 
// a size differing by more than 1. This may lead to some parts being null.
// The parts should be in order of occurrence in the input list, and parts occurring earlier 
// should always have a size greater than or equal parts occurring later.
// Return a List of ListNode's representing the linked list parts that are formed.
// Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
// See: https://leetcode.com/problems/split-linked-list-in-parts/

package leetcode.linkedlist;

import static leetcode.util.linkedlist.LinkedListUtil.initList;
import static leetcode.util.linkedlist.LinkedListUtil.printLinkedList;

import leetcode.util.linkedlist.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];

        int len = 0;
        for (ListNode i = root; i != null; i = i.next, len++);
        int longerPart = (int) Math.ceil((double) len / k);
        int longerPartCount = len % k != 0 ? len % k : k;

        int i = 0;
        ListNode prev = root;
        while (root != null && i < ans.length) {
            if (i == longerPartCount)
                longerPart--;

            ListNode start = root;
            for (int j = 0; j < longerPart; j++) {
                prev = root;
                root = root.next;
            }
            prev.next = null;
            ans[i++] = start;
        }

        return ans;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts sln = new SplitLinkedListInParts();
        ListNode[] ans = sln.splitListToParts(initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4);

//        ListNode[] ans = sln.splitListToParts(initList(1, 2, 3), 5);

//        ListNode[] ans = sln.splitListToParts(initList(0, 1), 2);
//        ListNode[] ans = sln.splitListToParts(initList(0, 1, 2, 3), 3);

        for (ListNode listNode : ans)
            printLinkedList(listNode);

    }
}
