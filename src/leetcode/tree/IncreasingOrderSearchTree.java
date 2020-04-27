// Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree 
// is now the root of the tree, and every node has no left child and only 1 right child.
// See: https://leetcode.com/problems/increasing-order-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class IncreasingOrderSearchTree {

    private TreeNode curr = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = curr;
        dfs(root);
        return res.right;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        dfs(root.right);
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree sln = new IncreasingOrderSearchTree();    

        TreeNode res = sln
                .increasingBST(initTree(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9));
        printInorder(res);
    }

}
