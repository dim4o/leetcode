// Given a binary tree, return the preorder traversal of its nodes' values.
// See: https://leetcode.com/problems/binary-tree-preorder-traversal/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinaryTreePreorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal sln = new BinaryTreePreorderTraversal();
        TreeNode t1 = initTree(1, null, 2, 3);
        TreeNode t2 = initTree(3, 9, 20, null, null, 15, 7);

        System.out.println(sln.inorderTraversal(t1));
        System.out.println(sln.inorderTraversal(t2));
    }
}
