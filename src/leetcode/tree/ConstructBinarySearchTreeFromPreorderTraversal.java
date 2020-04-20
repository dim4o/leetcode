// Return the root node of a binary search tree that matches the given preorder traversal.
// See: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

package leetcode.tree;

import leetcode.util.tree.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    // TODO: Add recursive solution
    public TreeNode bstFromPreorder(int[] preorder) {
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

    }

}
