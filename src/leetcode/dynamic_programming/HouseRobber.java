// You are a professional robber planning to rob houses along a street. Each house has a certain 
// amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent 
// houses have security system connected and it will automatically contact the police if two adjacent 
// houses were broken into on the same night.
// Given a list of non-negative integers representing the amount of money of each house, 
// determine the maximum amount of money you can rob tonight without alerting the police.
// See: https://leetcode.com/problems/house-robber/

package leetcode.dynamic_programming;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber sln = new HouseRobber();
        System.out.println(sln.rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(sln.rob(new int[] { 2, 7, 9, 3, 1 }));
        System.out.println(sln.rob(new int[] { 1, 2 }));
        System.out.println(sln.rob(new int[] { 2, 1 }));
        System.out.println(sln.rob(new int[] { 2, 1, 1, 2 }));
    }

}
