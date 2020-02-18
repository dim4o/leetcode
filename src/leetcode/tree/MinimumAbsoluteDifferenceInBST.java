// Given a binary search tree with non-negative values, 
// find the minimum absolute difference between values of any two nodes.
// See: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root, new ArrayList<>());
        return minDiff;
    }

    private void helper(TreeNode root, List<Integer> inorderList) {
        if (root != null) {
            helper(root.left, inorderList);

            if (!inorderList.isEmpty()) {
                int currDiff = Math.abs(root.val - inorderList.get(inorderList.size() - 1));
                minDiff = Math.min(currDiff, minDiff);
            }
            inorderList.add(root.val);

            helper(root.right, inorderList);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1, null, 3, 2, null);

        System.out.println(new MinimumAbsoluteDifferenceInBST()
                .getMinimumDifference(t1));

        System.out.println(new MinimumAbsoluteDifferenceInBST()
                .getMinimumDifference(initTree(1)));

        System.out.println(new MinimumAbsoluteDifferenceInBST()
                .getMinimumDifference(initTree()));

        System.out.println(new MinimumAbsoluteDifferenceInBST()
                .getMinimumDifference(initTree(5, 4, 7)));
    }

}
