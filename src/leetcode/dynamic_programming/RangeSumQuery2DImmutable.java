// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner 
// (row1, col1) and lower right corner (row2, col2).
// See: https://leetcode.com/problems/range-sum-query-2d-immutable/

package leetcode.dynamic_programming;

import java.util.Arrays;

public class RangeSumQuery2DImmutable {
    class NumMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix != null && matrix.length != 0) {
                dp = new int[matrix.length + 1][matrix[0].length + 1];
                
                for (int i = 0; i < matrix.length; i++) 
                    for (int j = 0; j < matrix[0].length; j++) 
                        dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j]; 
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
              };
        NumMatrix nm = new RangeSumQuery2DImmutable().new NumMatrix(matrix);
        
        System.out.println(nm.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(nm.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(nm.sumRegion(1, 2, 2, 4)); // 12
        
        System.out.println();
        for (int[] row : nm.dp) {
            System.out.println(Arrays.toString(row));
        }
        
        
        
        

    }

}
