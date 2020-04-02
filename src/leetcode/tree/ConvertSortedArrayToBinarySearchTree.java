// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
// See: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

package leetcode.tree;

import leetcode.util.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = construct(nums, l, mid - 1);
        curr.right = construct(nums, mid + 1, r);

        return curr;
    }

}
