// Given a binary tree, find its minimum depth.
// See: https://leetcode.com/problems/minimum-depth-of-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        
        if (root.left == null) {
            return helper(root.right, depth + 1);
        } else if (root.right == null) {
            return helper(root.left, depth + 1);
        }
        
        return Math.min(helper(root.left, depth + 1), helper(root.right, depth + 1));
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree sln = new MinimumDepthOfBinaryTree();
        
        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        TreeNode t2 = initTree(1, 2);
        
        System.out.println(sln.minDepth(t1)); // 2
        System.out.println(sln.minDepth(t2)); // 2
    }

}
