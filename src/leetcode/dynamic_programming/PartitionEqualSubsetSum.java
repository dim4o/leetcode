// Given a non-empty array containing only positive integers, find if the array can be partitioned 
// into two subsets such that the sum of elements in both subsets is equal.
// Note:
// Each of the array element will not exceed 100.
// The array size will not exceed 200.
// See: https://leetcode.com/problems/partition-equal-subset-sum/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    // TODO: Add bottom-up DP solution

    /**
     * Recursion with memorization (DP top-down) - accepted.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        Map<Integer, Boolean> memo = new HashMap<>();
        return helper(nums, 0, sum / 2, 0, memo);
    }

    private boolean helper(int[] nums, int currSum, int target, int start, Map<Integer, Boolean> memo) {
        if (currSum > target) return false;
        if (target == currSum) return true;

        for (int i = start; i < nums.length; i++) {
            int key = (currSum + nums[i])*100 + (i + 1);
            if (!memo.containsKey(key))
                memo.put(key, helper(nums, currSum + nums[i], target, i + 1, memo));

            if (memo.get(key)) return true;
        }
        return false;
    }
    
    /**
     * Initial solution - Concise but slow bruteforce recursion, not accepted(TLE).
     */
    public boolean canPartition_var1(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;

        return dfs(nums, 0, sum / 2, 0);
    }

    private boolean dfs(int[] nums, int currSum, int target, int start) {
        if (currSum > target) return false;
        if (target == currSum) return true;

        for (int i = start; i < nums.length; i++)
            if (dfs(nums, currSum + nums[i], target, i + 1)) return true;
       
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum sln = new PartitionEqualSubsetSum();
        System.out.println(sln.canPartition(new int[] { 1, 2, 5 }));
        System.out.println(sln.canPartition(new int[] { 1, 5, 11, 5 }));
        System.out.println(sln.canPartition(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        System.out.println(sln.canPartition(new int[] { 1, 2, 3, 5 }));
    }

}
