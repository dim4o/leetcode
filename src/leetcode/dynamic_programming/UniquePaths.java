// A robot is located at the top-left corner of a m x n grid 
// (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid 
// (marked 'Finish' in the diagram below).
// How many possible unique paths are there?
// See: https://leetcode.com/problems/unique-paths/

package leetcode.dynamic_programming;

public class UniquePaths {

    // DP solution with single array
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[j] += dp[j - 1];
            
        return dp[m - 1];
    }
    
    // DP solution with M x N matrix
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++)
            dp[0][i] = 1;
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePaths sln = new UniquePaths();

        System.out.println(sln.uniquePaths(3, 2));
        System.out.println(sln.uniquePaths(7, 3));
        System.out.println(sln.uniquePaths(1, 1));
    }

}
