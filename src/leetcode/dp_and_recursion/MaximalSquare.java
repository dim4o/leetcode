// Given a 2D binary matrix filled with 0's and 1's, 
// find the largest square containing only 1's and return its area.
// See: https://leetcode.com/problems/maximal-square/

package leetcode.dp_and_recursion;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] == '1' && i > 0 & j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(dp[i][j], max);
                } else if (matrix[i][j] == '1'){
                    max = Math.max(1, max);
                }
            }
        }
        
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare sln = new MaximalSquare();
            
        System.out.println(sln.maximalSquare(new char[][] { 
            { '1', '0', '1', '0', '0' }, 
            { '1', '0', '1', '1', '1' }, 
            { '1', '1', '1', '1', '1' }, 
            { '1', '0', '0', '1', '0' } })); // 4
        System.out.println(sln.maximalSquare(new char[][] {})); // 0
        System.out.println(sln.maximalSquare(new char[][] {{'1'}})); // 1
        System.out.println(sln.maximalSquare(new char[][] {{'1', '1'}, {'1', '1'}})); // 4
        System.out.println(sln.maximalSquare(new char[][] { 
            { '1', '0', '1', '0'}, 
            { '1', '0', '1', '1'}, 
            { '1', '0', '1', '1'}, 
            { '1', '1', '1', '1'} })); // 4
        System.out.println(sln.maximalSquare(new char[][] {
            {'1','0','1','0','0','1','1','1','0'},
            {'1','1','1','0','0','0','0','0','1'},
            {'0','0','1','1','0','0','0','1','1'},
            {'0','1','1','0','0','1','0','0','1'},
            {'1','1','0','1','1','0','0','1','0'},
            {'0','1','1','1','1','1','1','0','1'},
            {'1','0','1','1','1','0','0','1','0'},
            {'1','1','1','0','1','0','0','0','1'},
            {'0','1','1','1','1','0','0','1','0'},
            {'1','0','0','1','1','1','0','0','0'}})); // 4
    }
}
