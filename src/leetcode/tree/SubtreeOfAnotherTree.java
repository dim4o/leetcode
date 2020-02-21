// Given two non-empty binary trees s and t, check whether tree t has exactly 
// the same structure and node values with a subtree of s. 
// A subtree of s is a tree consists of a node in s and all of this node's descendants. 
// The tree s could also be considered as a subtree of itself.
// See: https://leetcode.com/problems/subtree-of-another-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        
        if (areSameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean areSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null && t2 != null || t1 != null && t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        
        return areSameTree(t1.left, t2.left) && areSameTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree sln = new SubtreeOfAnotherTree();
        TreeNode s1 = initTree(3, 4, 5, 1, 2);
        TreeNode t1 = initTree(4, 1, 2);
        TreeNode s2 = initTree(4, 1, 2, null, null, 0);
        
//        TreeNode t3 = initTree(4, 1, 2);
//        System.out.println(sln.areSameTree(t1, t2));
//        System.out.println(sln.areSameTree(t1, t3));
        
        System.out.println(sln.isSubtree(s1, t1));
        System.out.println(sln.isSubtree(s2, t1));

    }

}
