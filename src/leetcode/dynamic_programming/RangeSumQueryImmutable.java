// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
// See: https://leetcode.com/problems/range-sum-query-immutable/

package leetcode.dynamic_programming;

import java.util.Arrays;

public class RangeSumQueryImmutable {
    
    class NumArray {
        private int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++)
                dp[i + 1] = dp[i] + nums[i];
        }
        
        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }

    public static void main(String[] args) {
        NumArray na = new RangeSumQueryImmutable().new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(Arrays.toString(na.dp));
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }

}
