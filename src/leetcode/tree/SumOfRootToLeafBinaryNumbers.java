// Given a binary tree, each node has value 0 or 1.
// Each root-to-leaf path represents a binary number starting with the most significant bit.
// Return the sum of these numbers.
// See: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val + sum;
        }

        return helper(root.left, (root.val + sum) * 2) + helper(root.right, (root.val + sum) * 2);
    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers sln = new SumOfRootToLeafBinaryNumbers();
        TreeNode t1 = initTree(1, 0, 1, 0, 1, 0, 1);

        System.out.println(sln.sumRootToLeaf((t1)));
    }

}
