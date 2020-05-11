// Return the root node of a binary search tree that matches the given preorder traversal.
// See: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/

package leetcode.leetcode_challenge;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * Simple recursive solution.
     * Time complexity: O(n.log(n)).
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++)
            insert(root, preorder[i]);
        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }
    
    /**
     * Iterative solution.
     * Time complexity: O(n.log(n)).
     */
    public TreeNode bstFromPreorder_var1(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode curr = root;
            while (curr != null) {
                if (val < curr.val && curr.left != null) {
                    curr = curr.left;
                } else if (val < curr.val && curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                } else if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal sln = new ConstructBinarySearchTreeFromPreorderTraversal();
        TreeNode root = sln.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
        printInorder(root);
    }

}
