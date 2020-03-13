// We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
// Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
// See: https://leetcode.com/problems/binary-tree-pruning/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        containsOne(root);
        return root;
    }
    
    public boolean containsOne(TreeNode root) {
        if (root == null) return false;
        boolean l = containsOne(root.left);
        boolean r = containsOne(root.right);
        if (!l) root.left = null;
        if (!r) root.right = null;
        if (root.val == 1) return true;
        
        return l || r;
    }
    
    public static void main(String[] args) {
        BinaryTreePruning sln = new BinaryTreePruning();
        TreeNode root = initTree(1,1,0,1,1,0,1,0);
        TreeNode res = sln.pruneTree(root);
        printInorder(res);
    }

}
