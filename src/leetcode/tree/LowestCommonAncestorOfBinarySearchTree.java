// Given a binary search tree (BST), find the lowest common ancestor (LCA) 
// of two given nodes in the BST.
// See: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

    // Recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    // Simple iterative solution
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (true)
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;

    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinarySearchTree sln = new LowestCommonAncestorOfBinarySearchTree();
        TreeNode t = initTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(2), new TreeNode(8)).val);
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(0), new TreeNode(5)).val);
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(2), new TreeNode(4)).val);
    }

}
