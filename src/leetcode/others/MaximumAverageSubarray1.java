// Given an array consisting of n integers, find the contiguous subarray 
// of given length k that has the maximum average value. 
// And you need to output the maximum average value.
// See: https://leetcode.com/problems/maximum-average-subarray-i/

package leetcode.others;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        
        double maxSum = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum += nums[i + k] - nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray1 sln = new MaximumAverageSubarray1();
        System.out.println(sln.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
        System.out.println(sln.findMaxAverage(new int[] { 5 }, 1));
    }

}
