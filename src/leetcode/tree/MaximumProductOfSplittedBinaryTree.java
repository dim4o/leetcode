// Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge 
// such that the product of the sums of the subtrees are maximized.
// Since the answer may be too large, return it modulo 10^9 + 7.
// See: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class MaximumProductOfSplittedBinaryTree {
    
    /**
     * Solution 2 - Optimized Solution 1
     */
    long maxProduct = 1;
    long total = 0;
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        return (int)(maxProduct % (1e9 + 7));
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int sum = root.val + dfs(root.left) + dfs(root.right);
        maxProduct = Math.max(maxProduct, sum * (total - sum));
        return sum;
    }
    
    /**
     * Solution 1: Two DFS's + cashed sums
     */
    private Map<TreeNode, Integer> memo = new HashMap<>();
    private long max = 1;
    public int maxProduct_var1(TreeNode root) {
        helper(root, calcSum(root));
        return (int)(max % (1e9 + 7));
    }

    private void helper(TreeNode root, long total) {
        if (root == null) return;
        int sum1 = memo.getOrDefault(root.left, 0);
        int sum2 = memo.getOrDefault(root.right, 0);
        
        max = Math.max(max, Math.max(sum1 * (total - sum1), sum2 * (total - sum2)));
            
        helper(root.left, total);
        helper(root.right, total);
    }
    
    private int calcSum(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + calcSum(root.left) + calcSum(root.right);
        memo.put(root, sum);
        return sum;
    }
    
    public static void main(String[] args) {

    }

}
