// Given a binary tree and a sum, find all root-to-leaf 
// paths where each path's sum equals the given sum.
// See: https://leetcode.com/problems/path-sum-ii/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.tree.TreeNode;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, sum, new Stack<>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, Stack<Integer> currPath, List<List<Integer>> res) {
        if (root != null) {
            currPath.add(root.val);

            if (root.left == null && root.right == null && sum == root.val) {
                res.add(new ArrayList<>(currPath));
            }
            helper(root.left, sum - root.val, currPath, res);
            helper(root.right, sum - root.val, currPath, res);

            currPath.pop();
        }
    }

    public static void main(String[] args) {
        PathSum2 sln = new PathSum2();
        TreeNode t1 = initTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
//        printInorder(t1);

        System.out.println(sln.pathSum(t1, 22));
        System.out.println(sln.pathSum(null, 22));
    }
}
