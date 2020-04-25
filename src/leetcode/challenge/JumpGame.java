// Given an array of non-negative integers, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Determine if you are able to reach the last index.
// https://leetcode.com/problems/jump-game/

package leetcode.challenge;

public class JumpGame {
    /**
     * Recursion with memorization.
     * TODO: There is a fast greedy solution - find it.
     */
    private int[] memo;
    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int pos) {
        if (nums[pos] + pos >= nums.length - 1)
            return true;
        if (nums[pos] == 0)
            return false;

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

    public static void main(String[] args) {
        JumpGame sln = new JumpGame();
        System.out.println(sln.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(sln.canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(sln.canJump(new int[] { 2, 5, 0, 0 }));
    }

}
