// You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
// Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. 
// Chain of pairs can be formed in this fashion.
// Given a set of pairs, find the length longest chain which can be formed. 
// You needn't use up all the given pairs. You can select pairs in any order.
// See: https://leetcode.com/problems/maximum-length-of-pair-chain/

package leetcode.dynamic_programming;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int globalMax = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                globalMax = Math.max(globalMax, dp[i]);
            }
        }
        
        return globalMax;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain sln = new MaximumLengthOfPairChain();
        int[][] pairs = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 3, 4 } };
        
        System.out.println(sln.findLongestChain(pairs));
    }

}
