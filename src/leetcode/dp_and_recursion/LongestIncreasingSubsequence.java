// Given an unsorted array of integers, 
// find the length of longest increasing subsequence.
// See: https://leetcode.com/problems/longest-increasing-subsequence/

package leetcode.dp_and_recursion;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        // System.out.println(Arrays.toString(dp));
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sln = new LongestIncreasingSubsequence();
        System.out.println(sln.lengthOfLIS(
                new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 1
        
        System.out.println(sln.lengthOfLIS(null)); // 0
        System.out.println(sln.lengthOfLIS(new int[] {})); // 0
        System.out.println(sln.lengthOfLIS(new int[] {1})); // 1
        System.out.println(sln.lengthOfLIS(new int[] {1, 2})); // 2
        System.out.println(sln.lengthOfLIS(new int[] {2, 1})); // 1
    }

}
