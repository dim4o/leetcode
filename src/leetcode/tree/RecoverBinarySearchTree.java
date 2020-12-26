// You are given the root of a binary search tree (BST), where exactly two nodes of the tree
// were swapped by mistake. Recover the tree without changing its structure.
// https://leetcode.com/problems/recover-binary-search-tree/

package leetcode.tree;

import leetcode.util.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.util.tree.BinTreeUtil.initTree;
import static leetcode.util.tree.BinTreeUtil.printInorder;

public class RecoverBinarySearchTree {
    /**
     * Trivial solution, O(N) time, O(N) space.
     * TODO: Implement a recursive solution.
     * TODO: Implement O(1) space solution.
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);

        int left = 0, right = nodes.size() - 1;
        boolean leftFound = false, rightFound = false;
        while (!leftFound || !rightFound) {
            if (leftFound || nodes.get(left).val > nodes.get(left + 1).val) {
                leftFound = true;
            } else left++;

            if (rightFound || nodes.get(right).val < nodes.get(right - 1).val) {
                rightFound = true;
            } else right--;
        }
        // swap the values
        int leftVal = nodes.get(left).val;
        nodes.get(left).val = nodes.get(right).val;
        nodes.get(right).val = leftVal;
        // System.out.println(left + "," + right);
    }

    private void dfs(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        dfs(root.left, nodes);
        nodes.add(root);
        dfs(root.right, nodes);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree sln = new RecoverBinarySearchTree();
        // TreeNode t1 = initTree(6, 4, 3, 9, 5, 7, 10, 1);
        // TreeNode t1 = initTree(10, 5, 15, 0, 8, 13, 20, 2, -5, 6, 9, 12, 14, 18, 25);
        TreeNode t1 = initTree(5, 1, null,3,null,null,2);
        printInorder(t1);
        sln.recoverTree(t1);
        printInorder(t1);
    }
}
