// Binary Tree Coloring Game
// See: https://leetcode.com/problems/binary-tree-coloring-game/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class BinaryTreeColoringGame {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xPlayerNode = findNode(root, x);
        int lCount = countNodes(xPlayerNode.left);
        int rCount = countNodes(xPlayerNode.right);
        int max = Math.max(n - (lCount + rCount + 1), Math.max(lCount, rCount));
        return max > n - max;
    }

    private TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode l = findNode(root.left, val);
        TreeNode r = findNode(root.right, val);
        return l != null ? l : r;
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeColoringGame sln = new BinaryTreeColoringGame();
        TreeNode root = initTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println(sln.btreeGameWinningMove(root, 11, 3));
    }

}
