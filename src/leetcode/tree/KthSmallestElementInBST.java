// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
// Note:
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
// How would you optimize the kthSmallest routine?
// See: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335

package leetcode.tree;

import leetcode.util.tree.TreeNode;

public class KthSmallestElementInBST {
    /**
     * Time complexity O(log(N) + k) if the tree is balanced.
     * If the tree is not balanced - worst case time complexity is O(N + k)
     */
    private int kth = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return kth;
    }
    
    private void dfs(TreeNode root, int k) {
        if (root == null || count == k) return;
        
        dfs(root.left, k);
        if (++count == k) {
            kth = root.val;
            return;
        }
        dfs(root.right, k);
    }

}
