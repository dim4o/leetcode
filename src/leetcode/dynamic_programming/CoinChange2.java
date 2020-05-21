// You are given coins of different denominations and a total amount of money. 
// Write a function to compute the number of combinations that make up that amount. 
// You may assume that you have infinite number of each kind of coin.
// See: https://leetcode.com/problems/coin-change-2/

package leetcode.dynamic_programming;

import java.util.Arrays;

public class CoinChange2 {
    /**
     * Solution 3: Space optimized Bottom-Up Dynamic Programming implementation. 
     * O(M * N) time, O(M) space.
     * Note: for the concrete leetcode problem the denominations are sorted.
     */
    public int change(int amount, int[] coins) {
        Arrays.sort(coins); // necessary in the general case
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i < coins.length + 1; i++)
            for (int j = 1; j < dp.length; j++)
                if (coins[i - 1] <= j)
                    dp[j] = dp[j] + dp[j - coins[i - 1]];

        return dp[dp.length - 1];
    }

    /**
     * Solution 2: Bottom-Up Dynamic Programming implementation. 
     * O(M * N) time, O(M * N) space
     */
    public int change_var2(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

        return dp[dp.length - 1][dp[0].length - 1];
    }
    
    /**
     * Solution 1: Recursive Top-Down DP solution.
     */
    private int[][] memo;

    public int change_var1(int amount, int[] coins) {
        memo = new int[coins.length + 1][amount + 1];
        // Arrays.sort(coins);
        for (int[] mem : memo) 
            Arrays.fill(mem, -1);
        
        return recur(amount, coins, coins.length, amount);
    }

    private int recur(int amount, int[] coins, int coinIdx, int currAmount) {
        if (currAmount == 0)
            return 1;
        if (coinIdx == 0)
            return 0;

        if (coins[coinIdx - 1] > currAmount) {
            if (memo[coinIdx - 1][currAmount] == -1)
                memo[coinIdx - 1][currAmount] = recur(amount, coins, coinIdx - 1, currAmount);
            return memo[coinIdx - 1][currAmount];
        }

        if (memo[coinIdx - 1][currAmount] == -1)
            memo[coinIdx - 1][currAmount] = recur(amount, coins, coinIdx - 1, currAmount);
        
        if (memo[coinIdx][currAmount - coins[coinIdx - 1]] == -1) 
            memo[coinIdx][currAmount - coins[coinIdx - 1]] = recur(amount, coins, coinIdx,
                    currAmount - coins[coinIdx - 1]);
        
        return memo[coinIdx - 1][currAmount] + memo[coinIdx][currAmount - coins[coinIdx - 1]];

    }

    public static void main(String[] args) {
        CoinChange2 sln = new CoinChange2();
        System.out.println(sln.change(5, new int[] { 1, 2, 5 }));
        System.out.println(sln.change(3, new int[] { 2 }));
        System.out.println(sln.change(10, new int[] { 10 }));

    }
}
