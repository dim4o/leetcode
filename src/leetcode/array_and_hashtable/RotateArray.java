// Given an array, rotate the array to the right by k steps, where k is non-negative.
// Follow up:
//   - Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//   - Could you do it in-place with O(1) extra space?
// See: https://leetcode.com/problems/rotate-array/
// See: https://leetcode.com/problems/rotate-array/discuss/640848/Java-Two-Solutions

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class RotateArray {
    /**
     * O(n) time, O(1) space solution.
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 1 || k % nums.length == 0) return;
        int size = 0, i = 0, startIdx = 0;
        int curr = nums[0];
        while (size++ < nums.length) {
            // if there is a cycle
            if (i == startIdx) curr = nums[startIdx=++i];
            int tmp = nums[(i + k) % nums.length];
            nums[(i + k) % nums.length] = curr;
            curr = tmp;
            i = (i + k) % nums.length;
        }
    }

    /**
     * Simple O(n) time, O(n) space solution.
     */
    public void rotate_var1(int[] nums, int k) {
        int[] helper = new int[nums.length];
        for (int i = 0; i < helper.length; i++)
            helper[(i + k) % nums.length] = nums[i];

        for (int i = 0; i < helper.length; i++)
            nums[i] = helper[i];
    }

    public static void main(String[] args) {
        RotateArray sln = new RotateArray();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6};
        sln.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }

}
