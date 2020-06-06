// We write the integers of A and B (in the order they are given) on two separate horizontal lines.
// Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
//   - A[i] == B[j];
//   - The line we draw does not intersect any other connecting (non-horizontal) line.
// Note that a connecting lines cannot intersect even at the endpoints: 
// each number can only belong to one connecting line.
// Return the maximum number of connecting lines we can draw in this way.
// See: https://leetcode.com/problems/uncrossed-lines/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
// Same as: https://leetcode.com/problems/longest-common-subsequence/

package leetcode.dynamic_programming;

public class UncrossedLines {
    /**
     * Solution 1: Bottom-Up DP solution, O(m.n) time, O(m.n) space.
     * Same as @see: https://leetcode.com/problems/longest-common-subsequence/
     */
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            
        return dp[A.length][B.length];
    }

}
