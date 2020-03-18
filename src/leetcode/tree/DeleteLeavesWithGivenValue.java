// Given a binary tree root and an integer target, delete all the leaf nodes with value target.
// See: https://leetcode.com/problems/delete-leaves-with-a-given-value/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;
import static leetcode.util.tree.BinTreeUtil.printInorder;

import leetcode.util.tree.TreeNode;

public class DeleteLeavesWithGivenValue {
    
    /**
     * Simple recursive solution
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) 
            return null;
        
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        // This position is important - the check and actions are after the recursive all
        // This will insure the deletion of the "new" leafs
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        
        return root;
    }

    /**
     * Naive but actually fast solution
     */
    public TreeNode removeLeafNodes_naive(TreeNode root, int target) {
        TreeNode res = root;
        while (delete(root, null, target)) {
        }
        if (res.left == null && res.right == null && res.val == target)
            return null;

        return res;
    }

    private boolean delete(TreeNode root, TreeNode par, int target) {
        if (root == null)
            return false;

        boolean del = false;
        if (root.left == null && root.right == null && root.val == target && par != null) {
            if (par.left == root)
                par.left = null;
            if (par.right == root)
                par.right = null;
            del = true;
        }

        return delete(root.left, root, target) | delete(root.right, root, target) | del;
    }

    public static void main(String[] args) {
        TreeNode root1 = initTree(1, 2, 3, 2, null, 2, 4);
        TreeNode res1 = new DeleteLeavesWithGivenValue().removeLeafNodes(root1, 2);

        TreeNode root2 = initTree(1, 1, 1);
        TreeNode res2 = new DeleteLeavesWithGivenValue().removeLeafNodes(root2, 1);

        printInorder(res1);
        printInorder(res2);
    }

}
