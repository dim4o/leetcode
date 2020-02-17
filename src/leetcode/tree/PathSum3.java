// You are given a binary tree in which each node contains an integer value.
// Find the number of paths that sum to a given value.
// The path does not need to start or end at the root or a leaf, 
// but it must go downwards (traveling only from parent nodes to child nodes).
// See: https://leetcode.com/problems/path-sum-iii/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class PathSum3 {
    // TODO - find optimal solution

    /**
     * Solution 1 - Brute force solution with 2 DFS, O(N^2) time complexity
     */
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    private void dfs(TreeNode root, int sum) {
        if (root != null) {
            dfsHelper(root, sum);
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }

    private void dfsHelper(TreeNode root, int sum) {
        if (root == null)
            return;

        if (sum - root.val == 0) {
            count += 1;
        }

        dfsHelper(root.left, sum - root.val);
        dfsHelper(root.right, sum - root.val);
    }
    /**
     * Solution 1 end
     */

    public static void main(String[] args) {
        TreeNode t1 = initTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        printInorder(t1);
        TreeNode t2 = initTree(1, -2, -3, 1, 3, -2, null, -1);
        printInorder(t2);

        System.out.println(new PathSum3().pathSum(t1, 8));
        System.out.println(new PathSum3().pathSum(t2, -1));
    }
}
