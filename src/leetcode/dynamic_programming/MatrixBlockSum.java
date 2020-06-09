//Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] 
// is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) 
// is a valid position in the matrix.
// See: https://leetcode.com/problems/matrix-block-sum/
// Note: the problem is connected with: See: https://leetcode.com/problems/range-sum-query-2d-immutable/

package leetcode.dynamic_programming;

public class MatrixBlockSum {
    
    /**
     * O(m.n) time, O(n.m) space
     * Same idea as @see: RangeSumQuery2DImmutable
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] dp = new int[mat.length + 1][mat[0].length + 1];
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) 
            for (int j = 0; j < mat[0].length; j++) 
                dp[i + 1][j + 1] = mat[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int r1 = i - K >= 0 ? i - K : 0;
                int c1 = j - K >= 0 ? j - K : 0;
                int r2 = i + K < mat.length ? i + K : mat.length - 1;
                int c2 = j + K < mat[0].length ? j + K : mat[0].length - 1;
                res[i][j] = dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MatrixBlockSum sln = new MatrixBlockSum();
        System.out.println(
                sln.matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1));

        System.out.println(
                sln.matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 2));

    }

}
