// Given a binary tree root, the task is to return the maximum sum of all keys 
// of any sub-tree which is also a Binary Search Tree (BST).
// See: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// My solution at leetcode: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/545594/Java-Fast-and-Concise%3A-O(n)-time-O(1)-space

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class MaximumSumBSTinBinaryTree {
    /**
     * Solution 1 - Accepted, high performance. ~ O(n) time, O(1) space.
     */
    int max = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        maxSumHelper(root);
        return max >= 0 ? max : 0;
    }

    private int maxSumHelper(TreeNode root) {
        if (root == null) return 0;

        int left = maxSumHelper(root.left);
        int right = maxSumHelper(root.right);
        int sum = Integer.MIN_VALUE; // marks the tree as non-balanced
        // marks the tree as balanced if the children are balanced
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE)
            sum = root.val + left + right; 
        // the tree is not balanced if not satisfy the the definition
        if (root.left != null && root.val <= root.left.val
                || root.right != null && root.val >= root.right.val)
            sum = Integer.MIN_VALUE; 

        max = Math.max(max, sum);

        return sum;
    }

    /**
     * Solution 2 - Initial solution ~ O(n^2) time, O(1) space. Not accepted due
     * Time Limit Exceeded(TLE)
     */
    int maxSum = Integer.MIN_VALUE;

    public int maxSumBST_1(TreeNode root) {
        dfs(root);
        return maxSum >= 0 ? maxSum : 0;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        maxSum = Math.max(maxSum, getBSTsum(root));
        dfs(root.left);
        dfs(root.right);
    }

    private int getBSTsum(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left != null && root.val <= root.left.val)
            return Integer.MIN_VALUE;

        if (root.right != null && root.val >= root.right.val)
            return Integer.MIN_VALUE;

        int l = getBSTsum(root.left);
        if (l == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int r = getBSTsum(root.right);
        if (r == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return root.val + l + r;
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6);
        TreeNode t2 = initTree(4, 3, null, 1, 2);
        TreeNode t3 = initTree(-4, -2, -5);
        TreeNode t4 = initTree(2, 1, 3);
        TreeNode t5 = initTree(5, 4, 8, 3, null, 6, 3);
        TreeNode t6 = initTree();

        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t1)); // 20
        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t2)); // 2
        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t3)); // 0
        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t4)); // 6
        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t5)); // 7
        System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(t6)); // 0

    }

}
