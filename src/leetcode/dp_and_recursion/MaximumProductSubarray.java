// Given an integer array nums, find the contiguous subarray within an array 
// (containing at least one number) which has the largest product.
// See: https://leetcode.com/problems/maximum-product-subarray/

package leetcode.dp_and_recursion;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        // At least one of the this additional arrays can be redused
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < dpMax.length; i++) {
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(nums[i], nums[i] * dpMin[i - 1]));
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(nums[i], nums[i] * dpMax[i - 1]));

            max = Math.max(max, Math.max(dpMax[i], dpMin[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray sln = new MaximumProductSubarray();
        System.out.println(sln.maxProduct(new int[] { 2, 3, -2, 4 }));
        System.out.println(sln.maxProduct(new int[] { -2, 2, 3, -4 }));
        System.out.println(sln.maxProduct(new int[] { -2, 0, -1 }));
        System.out.println(sln.maxProduct(new int[] { -2, 3, -4 }));
        System.out.println(sln.maxProduct(new int[] { -2, -3, 7 }));
        System.out.println(sln.maxProduct(new int[] { -1, -2, -9, -6 }));
    }

}
