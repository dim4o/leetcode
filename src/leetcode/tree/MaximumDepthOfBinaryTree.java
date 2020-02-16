// Maximum Depth of Binary Tree
// See: https://leetcode.com/problems/maximum-depth-of-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        
        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }
    
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree sln = new MaximumDepthOfBinaryTree();

        TreeNode t0 = initTree();
        System.out.println(sln.maxDepth(t0)); // 0
        
        TreeNode t1 = initTree(1);
        System.out.println(sln.maxDepth(t1)); // 1
        
        TreeNode t2 = initTree(1, 1);
        System.out.println(sln.maxDepth(t2)); // 2
        
        TreeNode t3 = initTree(1, 2, null, 3);
        System.out.println(sln.maxDepth(t3)); // 3
        
        TreeNode t4 = initTree(1, 2, 4, 3, null);
        System.out.println(sln.maxDepth(t4)); // 3
        
        TreeNode t5 = initTree(3, 9, 20, null, null, 15, 7);
        System.out.println(sln.maxDepth(t5));
    }
}
