// Given a binary tree, determine if it is height-balanced.
// See: https://leetcode.com/problems/balanced-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class BalancedBinaryTree {
    private boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        helper(root, 0);

        return ans;
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        
        int leftDepth = helper(root.left, depth + 1);
        int rightDept = helper(root.right, depth + 1);

        if (Math.abs(leftDepth - rightDept ) > 1) {
            ans = false;
        }

        return Math.max(leftDepth, rightDept);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        TreeNode t2 = initTree(1, 2, 2, 3, 3, null, null, 4, 4);

        System.out.println(new BalancedBinaryTree().isBalanced(t1)); // true
        System.out.println(new BalancedBinaryTree().isBalanced(t2)); // false
    }

}
