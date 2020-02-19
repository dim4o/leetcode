// A binary tree is univalued if every node in the tree has the same value.
// Return true if and only if the given tree is univalued.
// https://leetcode.com/problems/univalued-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.left.val != root.val || 
                root.right != null && root.right.val != root.val)
            return false;

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree sln = new UnivaluedBinaryTree();
        TreeNode t1 = initTree(1, 1, 1, 1, 1, null, 1);
        TreeNode t2 = initTree(2, 2, 2, 5, 2);

        System.out.println(sln.isUnivalTree(t1)); // true
        System.out.println(sln.isUnivalTree(t2)); // false
    }

}
