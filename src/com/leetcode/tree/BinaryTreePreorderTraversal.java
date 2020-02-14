// Given a binary tree, return the preorder traversal of its nodes' values.
// See: https://leetcode.com/problems/binary-tree-preorder-traversal/

package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.tree.util.TreeNode;

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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;

        System.out.println(sln.inorderTraversal(n1));
    }
}
