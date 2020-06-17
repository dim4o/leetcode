// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
// Si % Sj = 0 or Sj % Si = 0.
// If there are multiple solutions, return any subset is fine.
// See: https://leetcode.com/problems/largest-divisible-subset/
// See: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
        
package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
    /**
     * Solution 1: Similar to LIS(Longest Increasing Subsequence) problem.
     * At the first look this connection is obvious but a very important moment is sorting the input,
     * because if: `nums[i] % nums[j] == 0` where `i > j` means that for every `nums[k]` such that 
     * `nums[j] % nums[k] == 0` (j > k) => `nums[j] % nums[k] == 0`.
     */
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums); // very important action
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 0;
        int end = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                end = i;
            }
        }
        
        while (true) {
            if (prev[end] == -1) {
                res.addFirst(nums[end]);
                break;
            }
            res.addFirst(nums[end]);
            end = prev[end];
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 1 }));
        
        System.out.println(
                new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 1, 2, 3 }));

        System.out.println(
                new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));

        System.out.println(
                new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 17, 2, 4, 5 }));

        System.out.println(
                new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 2, 3, 4, 13, 8 }));

        System.out.println(
                new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 3, 4, 16, 8, 5 }));

        System.out.println(new LargestDivisibleSubset()
                .largestDivisibleSubset(new int[] { 3, 4, 16, 5, 2, 1, 8, 11 }));
        
        System.out.println(new LargestDivisibleSubset()
                .largestDivisibleSubset(new int[] { 3, 4}));

    }

}
