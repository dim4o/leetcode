// Given a complete binary tree, count the number of nodes.
// Note:
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, 
// and all nodes in the last level are as far left as possible. It can have between 1 and 2h 
// nodes inclusive at the last level h.
// See: https://leetcode.com/problems/count-complete-tree-nodes/

package leetcode.tree;

import leetcode.util.tree.TreeNode;

public class CountCompleteTreeNodes {
    /**
     * Solution 2: Use the complete binary tree properties.
     * Time complexity - O(depth^2) = O(log(n)^2)
     */
    public int countNodes(TreeNode root) {
        if (root == null) 
            return 0;

        int l = 0, r = 0;
        TreeNode r1 = root, r2 = root;
        while (r1 != null) {
            l++;
            r1 = r1.left;
        }
        while (r2 != null) {
            r++;
            r2 = r2.right;
        }
        
        // if left == right count -> the subtree is full binary tree
        if (l == r)
            // this is the sum of the full binary tree: 1 + 2 + 4 = 2^3 - 1
            return (1 << l) - 1;
        // 1 -> count the current node 
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    /**
     * Solution 1: Very simple but it doesn't use any property of the complete binary tree.
     * O(n) time
     * O(n) space (with the stack trace)
     */
    public int countNodes_var1(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes_var1(root.left) + countNodes_var1(root.right);
    }
    
}
