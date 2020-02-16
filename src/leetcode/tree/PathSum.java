// Given a binary tree and a sum, determine if the tree has a root-to-leaf 
// path such that adding up all the values along the path equals the given sum.
// See: https://leetcode.com/problems/path-sum/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || 
                hasPathSum(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        PathSum sln = new PathSum();

        TreeNode t1 = initTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, 1);
        printInorder(t1);
        
        TreeNode t2 = initTree(1, 2);
        printInorder(t2);
        
        TreeNode t3 = initTree();
        printInorder(t3);

        System.out.println(sln.hasPathSum(t1, 22)); // true
        System.out.println(sln.hasPathSum(t2, 1)); // false
        System.out.println(sln.hasPathSum(t3, 0)); // false
    }
}
