// Given the root node of a binary search tree, return the sum of values of 
// all nodes with value between L and R (inclusive).
// The binary search tree is guaranteed to have unique values.
// See: https://leetcode.com/problems/range-sum-of-bst/

package leetcode.tree;

import leetcode.util.tree.TreeNode;

public class RangeSumofBST {
    
    /**
     * Solution 2 - Fast and effective (reduced recursion calls)
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        
        if (root.val < L)
            return rangeSumBST(root.right, L, R);
        else if (root.val > R){
            return rangeSumBST(root.left, L, R);
        }

        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    /**
     * Solution 1 (Initial solution, accepted).
     * Working and easy but not super effective solution.
     */
    public int rangeSumBST_(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        
        int sum = 0;
        if (root.val >= L && root.val <= R)
            sum += root.val;

        return sum + rangeSumBST_(root.left, L, R) + rangeSumBST_(root.right, L, R);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
