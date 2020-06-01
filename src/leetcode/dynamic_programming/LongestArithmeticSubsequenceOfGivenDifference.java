// Given an integer array arr and an integer difference, return the length of the longest subsequence 
// in arr which is an arithmetic sequence such that the difference between adjacent elements 
// in the subsequence equals difference.
// See: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    /**
     * Solution 1: Bottom-Up Dynamic Programming with HashMap.
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            max = Math.max(max, dp.get(num));
        }
        return max;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference sln = new LongestArithmeticSubsequenceOfGivenDifference();
        System.out.println(sln.longestSubsequence(new int[] {1, 2, 3, 4}, 1));
    }

}
