// Given a Binary Search Tree (BST) with the root node root, return the minimum difference 
// between the values of any two different nodes in the tree.
// See: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.LinkedList;

import leetcode.util.tree.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    
    /**
     * Solution 2 - Optimized solution.
     */
    Integer prev = null;
    Integer ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        if (prev != null)
            ans = Math.min(ans, Math.abs(root.val - prev));
        prev = root.val;
        dfs(root.right);
    }
    
    /**
     * Solution 1 - Initial solution
     */
    int min = Integer.MAX_VALUE;
    public int minDiffInBST_var1(TreeNode root) {
        helper(root, new LinkedList<>());
        return min;
    }
    
    private void helper(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;
        
        helper(root.left, list);
        if (!list.isEmpty())
            min = Math.min(min, Math.abs(root.val - list.getLast()));
        list.add(root.val);
        helper(root.right, list);
    }
    
    public static void main(String[] args) {
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(initTree(4,2,6,1,3,null,null)));
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(initTree(90,69,null,49,89,null,52,null,null,null,null)));
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(initTree(27,null,34,null,58,50,null,44,null,null,null)));
    }

}
