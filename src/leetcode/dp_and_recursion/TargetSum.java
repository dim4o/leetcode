// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
// Now you have 2 symbols + and -. For each integer, 
// you should choose one from + and - as its new symbol.
// Find out how many ways to assign symbols to make sum of integers equal to target S.
// See: https://leetcode.com/problems/target-sum/solution/

package leetcode.dp_and_recursion;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        // Clean recursion
        // return recur(nums, 0, S, 0);
        
        // Top-Down Dynamic Programming (Recursion with memorization)
        return recurMemo(nums, 0, S, 0);
        
        // TODO: Add Bottom-Up Dynamic Programming implementation
    }

    // Clean recursive solution
    @SuppressWarnings("unused")
    private int recur(int nums[], int sum, int target, int i) {
        if (i == nums.length)
            return sum == target ? 1 : 0;

        return recur(nums, nums[i] + sum, target, i + 1)
                + recur(nums, -nums[i] + sum, target, i + 1);
    }

    // Optimized solution with memorization for better time performance
    private Map<Integer, Integer> memo = new HashMap<>();
    @SuppressWarnings("unused")
    private int recurMemo(int nums[], int sum, int target, int i) {
        if (i == nums.length)
            return sum == target ? 1 : 0;

        int plusCount, minusCount = 0;
        int plusKey = (nums[i] + sum) * 100_000 + i;
        int minusKey = (-nums[i] + sum) * 100_000 + i;

        if (memo.containsKey(plusKey))
            plusCount = memo.get(plusKey);
        else {
            plusCount = recurMemo(nums, nums[i] + sum, target, i + 1);
            memo.put(plusKey, plusCount);
        }
        if (memo.containsKey(minusKey))
            minusCount = memo.get(minusKey);
        else {
            minusCount = recurMemo(nums, -nums[i] + sum, target, i + 1);
            memo.put(minusKey, minusCount);
        }

        return plusCount + minusCount;
    }

    public static void main(String[] args) {
        TargetSum sln = new TargetSum();

        System.out.println(sln.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
    }

}
