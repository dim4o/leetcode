// Given a binary tree, flatten it to a linked list in-place.
// See: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            TreeNode leftNode = root.left;
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            
            leftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public void flatten1(TreeNode root) {
        List<TreeNode> l = dfs(root, new ArrayList<>());
        for (int i = 1; i < l.size(); i++) {
            root.right = l.get(i);
            root.left = null;
            root = root.right;
        }
    }

    private List<TreeNode> dfs(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return new ArrayList<>();
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList sln = new FlattenBinaryTreeToLinkedList();
        TreeNode root = initTree(1, 2, 5, 3, 4, 6);
        sln.flatten(root);

        printInorder(root);

    }

}
