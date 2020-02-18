// Invert a binary tree.
// See: https://leetcode.com/problems/invert-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class InvertBinaryTree {
    /**
     * Uses a helper class that modifies the tree
     */
    public TreeNode invertTree_1(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        helper(root.left);
        helper(root.right);
    }

    /**
     * Inverts a tree without helper
     * @return the root directly from the recursion
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree sln = new InvertBinaryTree();
        TreeNode t1 = initTree(4, 2, 7, 1, 3, 6, 9);
        TreeNode t2 = initTree(1);
        TreeNode t3 = initTree(1, 2);

        printInorder(sln.invertTree(t1));
        printInorder(sln.invertTree(t2));
        printInorder(sln.invertTree(null));
        printInorder(sln.invertTree(t3));
    }

}
