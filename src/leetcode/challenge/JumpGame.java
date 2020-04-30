// Given an array of non-negative integers, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Determine if you are able to reach the last index.
// See: https://leetcode.com/problems/jump-game/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/

package leetcode.challenge;

public class JumpGame {
    /**
     * Recursion with memorization (for the initial solution)
     * TODO: There is a fast greedy solution - find it.
     */
    private int[] memo;
    public boolean canJump_(int[] nums) {
        memo = new int[nums.length];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int pos) {
        if (nums[pos] + pos >= nums.length - 1)
            return true;

        if (memo[pos] != 0)
            return memo[pos] == 1 ? true : false;

        boolean res = false;
        for (int i = pos + 1; i <= nums[pos] + pos; i++) {
            if (memo[i] != 0)
                res = res || memo[pos] == 1 ? true : false;
            else 
                res = res || dfs(nums, i);
        }
        memo[pos] = res ? 1 : -1;

        return res;
    }
    
    /**
     * Initial solution - not accepted (TLE)
     */
    public boolean canJump_var1(int[] nums) {
        return dfs1(nums, 0);
    }
    private boolean dfs1(int[] nums, int pos) {
        if (nums[pos] + pos >= nums.length - 1)
            return true;
        
        boolean res = false;
        for (int i = pos + 1; i <= nums[pos] + pos; i++)
            res = res || dfs1(nums, i);
        
        return res;
    }
    
    /**
     * Recursion with memorization.
     */
    public boolean canJump____(int[] nums) {
        return helper(nums, nums.length - 1, new int[nums.length]);
    }
    private boolean helper(int[] nums, int end, int[] memo) {
        if (nums[0] >= end)
            return true;

        for (int i = 1; i < end; i++) {
            if (nums[i] + i >= end) {
                if (memo[i] == 0)
                    memo[i] = helper(nums, i, memo) ? 1 : -1;
                return memo[i] == 1 ? true : false;
            }
        }
        
        return false;
    }
    
    
    /**
     * Another recursive solution.
     */
    public boolean canJump(int[] nums) {
        return lab(nums, nums.length - 1);
    }
    private boolean lab(int[] nums, int end) {
        if (nums[0] >= end)
            return true;

        for (int i = 1; i < end; i++) {
            if (nums[i] + i >= end) 
                return lab(nums, i);
        }
        
        return false;
    }

    public static void main(String[] args) {
        JumpGame sln = new JumpGame();
        System.out.println(sln.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(sln.canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(sln.canJump(new int[] { 2, 5, 0, 0 }));
    }

}
