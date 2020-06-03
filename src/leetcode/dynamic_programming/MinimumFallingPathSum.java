// Given a square array of integers A, we want the minimum sum of a falling path through A.
// A falling path starts at any element in the first row, and chooses one element from each row.  
// The next row's choice must be in a column that is different from the previous row's column 
// by at most one
// See: https://leetcode.com/problems/minimum-falling-path-sum/

package leetcode.dynamic_programming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    /**
     * O(N^2) time, O(N^2) space
     */
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length + 2];
        for (int[] row : dp)
            Arrays.fill(row, 100);
        for (int i = 0; i < A[0].length; i++)
            dp[0][i + 1] = A[0][i];

        for (int i = 1; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                dp[i][j + 1] = Math.min(Math.min(dp[i - 1][j + 1], dp[i - 1][j]), dp[i - 1][j + 2])
                        + A[i][j];

        int min = 100;
        for (int i = 1; i < dp[0].length - 1; i++)
            min = Math.min(min, dp[dp.length - 1][i]);

        return min;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum sln = new MinimumFallingPathSum();

        System.out.println(sln.minFallingPathSum(
                new int[][] { { 3, 4, 5, 0 }, { 8, 6, 1, 9 }, { 7, 2, 10, 11 } }));
    }

}
