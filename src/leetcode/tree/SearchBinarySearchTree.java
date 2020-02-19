// Given the root node of a binary search tree (BST) and a value. 
// You need to find the node in the BST that the node's value 
// equals the given value. Return the subtree rooted with that node. 
// If such node doesn't exist, you should return NULL.
// See: https://leetcode.com/problems/search-in-a-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class SearchBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(4, 2, 7, 1, 3);

        printInorder(new SearchBinarySearchTree().searchBST(t1, 2));
        printInorder(new SearchBinarySearchTree().searchBST(t1, 20));
        printInorder(new SearchBinarySearchTree().searchBST(null, 20));
    }

}
