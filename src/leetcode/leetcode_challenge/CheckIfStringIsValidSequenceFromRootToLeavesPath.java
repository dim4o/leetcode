// Given a binary tree where each path going from the root to any leaf form a valid sequence, 
// check if a given string is a valid sequence in such binary tree. 
// We get the given string from the concatenation of an array of integers arr and the concatenation 
// of all values of the nodes along a path results in a sequence in the given binary tree.
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/

package leetcode.leetcode_challenge;

import leetcode.util.tree.TreeNode;

public class CheckIfStringIsValidSequenceFromRootToLeavesPath {
    
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }
    
    private boolean dfs(TreeNode root, int[] arr, int i) {
        if (root == null || i == arr.length || root.val != arr[i])
            return false;

        if (i == arr.length - 1 && root.left == null && root.right == null) 
            return true;

        return dfs(root.left, arr, i + 1) || dfs(root.right, arr, i + 1);
    }

}
