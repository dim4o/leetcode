// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
// stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor 
// of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact 
// the police if two adjacent houses were broken into on the same night.
// Given a list of non-negative integers representing the amount of money of each house, 
// determine the maximum amount of money you can rob tonight without alerting the police.
// See: https://leetcode.com/problems/house-robber-ii/
// See: https://leetcode.com/problems/house-robber-ii/discuss/652861/Java-Simple-DP

package leetcode.dynamic_programming;

public class HouseRobber2 {
    
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
       
        int[][] dp = new int[2][nums.length];
        dp[0][1] = nums[0];
        dp[1][1] = nums[1];

        for (int i = 2; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[0][i - 2] + nums[i - 1], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + nums[i], dp[1][i - 1]);
        }

        return Math.max(dp[0][dp[0].length - 1], dp[1][dp[0].length - 1]);
    }

    public static void main(String[] args) {
        HouseRobber2 sln = new HouseRobber2();
        System.out.println(sln.rob(new int[] { 2, 3, 2 }));
        System.out.println(sln.rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(sln.rob(new int[] { 1, 2, 1, 1 }));
        System.out.println(sln.rob(new int[] { 1, 3, 1, 3, 100 }));
    }

}
