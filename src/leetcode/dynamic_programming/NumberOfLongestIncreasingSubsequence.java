// Given an unsorted array of integers, find the number of longest increasing subsequence.
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

package leetcode.dynamic_programming;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dpLen = new int[nums.length];
        int[] dpCount = new int[nums.length];
        dpLen[0] = 1;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            dpLen[i] = 1;
            dpCount[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpLen[i] = Math.max(dpLen[i], dpLen[j] + 1);
                }
            }

            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dpLen[j] == dpLen[i] - 1) {
                    sum += dpCount[j];
                }
            }

            dpCount[i] = Math.max(dpCount[i], sum);
            maxLen = Math.max(maxLen, dpLen[i]);
        }

//    System.out.println(Arrays.toString(dp));
//    System.out.println(Arrays.toString(dp2));

        int result = 0;
        for (int i = 0; i < dpLen.length; i++) {
            if (dpLen[i] == maxLen) {
                result += dpCount[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence sln = new NumberOfLongestIncreasingSubsequence();

        System.out.println(sln.findNumberOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 1
        System.out.println(sln.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 })); // 5
        System.out.println(sln.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 })); // 2
        System.out.println(sln.findNumberOfLIS(new int[] { 1, 5, 2, 6, 3, 0 })); // 3
    }
}
