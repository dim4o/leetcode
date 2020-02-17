// Given a binary tree containing digits from 0-9 only, 
// each root-to-leaf path could represent a number.
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
// Find the total sum of all root-to-leaf numbers.
// See: https://leetcode.com/problems/sum-root-to-leaf-numbers/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class SumRootToLeafNumbers {
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return curr * 10 + root.val;
        }

        return helper(root.left, curr * 10 + root.val) + 
                helper(root.right, curr * 10 + root.val);
    }
    
    /**
     * String concatenation solution
     */
    public int sumNumbers1(TreeNode root) {
        return dfs(root, "");
    }

    private int dfs(TreeNode root, String curr) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(curr + root.val);
        }

        return dfs(root.left, curr + root.val) + dfs(root.right, curr + root.val);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sln = new SumRootToLeafNumbers();
        TreeNode t1 = initTree(1, 2, 3);
//        printInorder(t1);

        System.out.println(sln.sumNumbers(t1));
        System.out.println(sln.sumNumbers(null));

    }

}
