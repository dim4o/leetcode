// Given two binary trees and imagine that when you put one of them to cover the other, 
// some nodes of the two trees are overlapped while the others are not.
// You need to merge them into a new binary tree. 
// The merge rule is that if two nodes overlap, 
// then sum node values up as the new value of the merged node. 
// Otherwise, the NOT null node will be used as the node of new tree.
// See: https://leetcode.com/problems/merge-two-binary-trees/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        
        if (t2 == null) 
            return t1;
        
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees sln = new MergeTwoBinaryTrees();
        TreeNode t1 = initTree(1, 3, 2, 5, null);
        TreeNode t2 = initTree(2, 1, 3, null, 4, null, 7);

        TreeNode res = sln.mergeTrees(t1, t2);
        printInorder(res);
    }

}
