// Given an unsorted array of integers, find the length of 
// longest continuous increasing subsequence (subarray).
// See: https://leetcode.com/problems/longest-continuous-increasing-subsequence/

package leetcode.array_and_hashtable;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int lcis = 1, count = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1])
                lcis = Math.max(lcis, ++count);
            else
                count = 1;
        
        return lcis;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence sln = new LongestContinuousIncreasingSubsequence();
        System.out.println(sln.findLengthOfLCIS(new int[] {}));
        System.out.println(sln.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
        System.out.println(sln.findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
        System.out.println(sln.findLengthOfLCIS(new int[] { 1, 1, 2, 3, 1 }));
    }

}
