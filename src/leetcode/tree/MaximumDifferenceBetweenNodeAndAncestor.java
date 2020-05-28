// Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B 
// where V = |A.val - B.val| and A is an ancestor of B.
// See: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    // TODO: Add more effective solution.
    /**
     * Solution 1: Do DFS from each node. Very easy (brute-force) recursive
     * solution.
     */
    private int max = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return max;

        dfs(root, root.val);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);

        return max;
    }

    private void dfs(TreeNode root, int ancestorVal) {
        if (root == null)
            return;

        max = Math.max(Math.abs(root.val - ancestorVal), max);
        dfs(root.left, ancestorVal);
        dfs(root.right, ancestorVal);
    }

    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeAndAncestor sln = new MaximumDifferenceBetweenNodeAndAncestor();
        
        System.out.println(sln.maxAncestorDiff(initTree(8,3,10,1,6,null,14,null,null,4,7,13)));
    }

}
