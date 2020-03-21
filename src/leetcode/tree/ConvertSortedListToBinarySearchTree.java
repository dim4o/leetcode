// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the 
// two subtrees of every node never differ by more than 1.
// See: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;
import static leetcode.util.linkedlist.LinkedListUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.linkedlist.ListNode;
import leetcode.util.tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return constTree(list, 0, list.size() - 1);
    }
    
    private TreeNode constTree(List<Integer> list, int l, int r) {
        if (l > r) 
            return null;
        
        int mid = (l + r) / 2;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = constTree(list, l, mid - 1);
        curr.right = constTree(list, mid + 1, r);
        return curr;
    }
    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree sln = new ConvertSortedListToBinarySearchTree();
        ListNode head = initList(-10,-3,0,5,9);
        TreeNode t = sln.sortedListToBST(head);
        printLinkedList(head);
        printInorder(t);
    }

}
