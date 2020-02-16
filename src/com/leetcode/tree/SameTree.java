// Given two binary trees, write a function to check if they are the same or not.
// See: https://leetcode.com/problems/same-tree/

package com.leetcode.tree;

import static com.leetcode.tree.util.BinTreeUtil.*;

import com.leetcode.tree.util.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null ^ q != null || p != null && q != null && p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(
                initTree(1, 2, 3), 
                initTree(1, 2, 3))); // true
        
        System.out.println(new SameTree().isSameTree(
                initTree(1, 2), 
                initTree(1, null, 2))); // false
        
        System.out.println(new SameTree().isSameTree(
                initTree(1, 2, 1), 
                initTree(1, 1, 2))); // false

    }

}
