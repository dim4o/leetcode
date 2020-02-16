// Given a binary tree, return the inorder traversal of its nodes' values.
// See: https://leetcode.com/problems/binary-tree-inorder-traversal/

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal sln = new BinaryTreeInorderTraversal();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        
        System.out.println(sln.inorderTraversal(n1));;
    }
}
