// Find the sum of all left leaves in a given binary tree.
// See: https://leetcode.com/problems/sum-of-left-leaves/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
                
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val;
        }

        return helper(root.left) + helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        TreeNode t2 = initTree(1, 2, 3, 4, 5);

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(t1));
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(t2));

    }

}
