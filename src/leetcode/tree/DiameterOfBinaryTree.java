// Given a binary tree, you need to compute the length of the diameter of the tree. 
// The diameter of a binary tree is the length of the longest path between 
// any two nodes in a tree. 
// This path may or may not pass through the root.
// See: https://leetcode.com/problems/diameter-of-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class DiameterOfBinaryTree {
    
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);

        return Math.max(left + 1, right + 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1, 2, 3, 4, 5, null, null, null, 10, 6, null, null, null, 8);
        System.out.println(new DiameterOfBinaryTree()
                .diameterOfBinaryTree(t1));
        
        System.out.println(new DiameterOfBinaryTree()
                .diameterOfBinaryTree(initTree(1)));
    }

}
