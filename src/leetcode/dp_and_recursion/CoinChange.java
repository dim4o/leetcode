// You are given coins of different denominations and a total amount of money amount. 
// Write a function to compute the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.
// See: https://leetcode.com/problems/coin-change/

package leetcode.dp_and_recursion;

import java.util.Arrays;

public class CoinChange {

    /**
     * Time complexity O(NxM), O(NxM) space.
     * TODO: rewrite with O(N) space
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int n = coins.length + 1;
        int m = amount + 1;
        int[][] dp = new int[n][m];

        for (int j = 1; j < m; j++)
            dp[0][j] = amount + 1;

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }

        return dp[n - 1][m - 1] <= amount ? dp[n - 1][m - 1] : -1;
    }

    /**
     * Good idea but very ugly implementation
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);

        int n = coins.length;
        int m = amount + 1;
        int[][] dp = new int[n][m];

        for (int j = 1; j < dp[0].length; j++) {
            if (j >= coins[0] && j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (coins[i] == j) {
                    dp[i][j] = 1;
                } else if (j >= coins[i] && dp[i - 1][j] == 0 && dp[i][j - coins[i]] > 0) {
                    dp[i][j] = dp[i][j - coins[i]] + 1;
                } else if (j < coins[i] || dp[i][j - coins[i]] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        // printTable(dp);
        return dp[n - 1][m - 1] != 0 ? dp[n - 1][m - 1] : -1;
    }

    public static void main(String[] args) {
        CoinChange sln = new CoinChange();
        System.out.println(sln.coinChange(new int[] { 4, 5 }, 6));
        System.out.println(sln.coinChange(new int[] { 1, 3, 5 }, 10));
        System.out.println(sln.coinChange(new int[] { 2 }, 3));
        System.out.println(sln.coinChange(new int[] { 1 }, 0));
        System.out.println(sln.coinChange(new int[] { 3, 4, 5 }, 8));
        System.out.println(sln.coinChange(new int[] { 186, 419, 83, 408 }, 6249));

    }
    
    @SuppressWarnings("unused")
    private void printTable(int[][] dp) {
        for (int[] line : dp) {
            System.out.println(Arrays.toString(line));
        }
    }

}
