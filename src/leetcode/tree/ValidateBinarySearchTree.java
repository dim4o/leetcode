// Given a binary tree, determine if it is a valid binary search tree (BST).
// See: https://leetcode.com/problems/validate-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class ValidateBinarySearchTree {
    /**
     * Solution 1
     * 
     * Not optimal solution with O(N) time complexity and O(N) space.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */
    public boolean isValidBST_slow(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i-1)) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    /**
     * Solution 2
     * 
     * Optimized solution with O(N) time complexity and O(1) space.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */
    private boolean isBinarySearchTree = true;
    private Integer prev = null;
    
    public boolean isValidBST(TreeNode root) {
        dfsOpt(root);
        
        return isBinarySearchTree;
    }
    
    private void dfsOpt(TreeNode root) {
        if (root != null && isBinarySearchTree) {
            dfsOpt(root.left);
            if (prev != null && prev >= root.val) {
                isBinarySearchTree = false;
                return;
            }
            prev = root.val;
            dfsOpt(root.right);
        }
    }
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    // TODO: Solution 3: Recursion solution
    
    // TODO: Solution 4: DFS with stack solution

    public static void main(String[] args) {
        TreeNode n1 = initTree(5,1,4,null,null,3,6);
        System.out.println(new ValidateBinarySearchTree().isValidBST(n1));
        
        TreeNode n2 = initTree(2, 1, 3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(n2));
        
        TreeNode n3 = initTree(10, 5, 15 ,null, null, 6, 20);
        System.out.println(new ValidateBinarySearchTree().isValidBST(n3));
        
        TreeNode n4 = initTree(1, 1);
        System.out.println(new ValidateBinarySearchTree().isValidBST(n4));
    }
}
