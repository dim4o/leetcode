// Given the root node of a binary search tree (BST) and a value to be inserted 
// into the tree, insert the value into the BST. 
// Return the root node of the BST after the insertion. 
// It is guaranteed that the new value does not exist in the original BST.
// See: https://leetcode.com/problems/insert-into-a-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class InsertIntoBinarySearchTree {

    /**
     * Recursive solution 1 (Elegant)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;
    }

    /**
     * Recursive solution 2
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return null;

        if (val < root.val && root.left == null)
            root.left = new TreeNode(val);
        else if (val < root.val)
            insertIntoBST2(root.left, val);
        else if (root.right == null)
            root.right = new TreeNode(val);
        else
            insertIntoBST2(root.right, val);

        return root;
    }

    /**
     * Iterative solution
     */
    public TreeNode insertIntoBST_iterative(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBinarySearchTree sln = new InsertIntoBinarySearchTree();

        TreeNode t1 = initTree(4, 2, 7, 1, 3);
        printInorder(sln.insertIntoBST(t1, 5));
        printInorder(sln.insertIntoBST(null, 5));
        printInorder(sln.insertIntoBST(initTree(1), 5));

    }

}
