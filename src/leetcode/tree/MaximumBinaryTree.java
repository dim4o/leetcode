// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//     - The root is the maximum number in the array.
//     - The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//     - The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
// Construct the maximum tree by the given array and output the root node of this tree.
// See: https://leetcode.com/problems/maximum-binary-tree/
//
// Note: This is also called a Cartesian Tree. One interesting property is that if we do 
// an in-order traversal, we get the array back which we used to create it.

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.printInorder;

import leetcode.util.tree.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode curr = new TreeNode(nums[maxIndex]);

        curr.left = construct(nums, start, maxIndex - 1);
        curr.right = construct(nums, maxIndex + 1, end);

        return curr;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++)
            if (nums[i] > nums[maxIndex]) 
                maxIndex = i;
        return maxIndex;
    }

    public static void main(String[] args) {
        MaximumBinaryTree sln = new MaximumBinaryTree();
        int[] nums = new int[] { 3, 2, 1, 6, 0, 5 };

        TreeNode tree = sln.constructMaximumBinaryTree(nums);
        System.out.println(tree.val);
        
        printInorder(tree);
    }

}
