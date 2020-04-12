// Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
//
// Example:
//
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// See: https://leetcode.com/problems/maximum-subarray/
    
package leetcode.dynamic_programming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
        }
        
        return maxSum;
    }
    
    public int maxSubArray_bruteforce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum > maxSum)
                    maxSum = currSum;
            }
        }
        
        return maxSum;
    }

    public static void main(String... args) {
        MaximumSubarray sln = new MaximumSubarray();
        System.out.println(sln.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println(sln.maxSubArray(new int[] { 1 }));
        System.out.println(sln.maxSubArray(new int[] { 1, -2 }));
        System.out.println(sln.maxSubArray(new int[] { -2, 1 }));
    }
}
