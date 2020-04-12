// Write an efficient algorithm that searches for a value in an m x n matrix. 
// This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// See: https://leetcode.com/problems/search-a-2d-matrix-ii/
// See: https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/572301/Java-Three-Solutions

package leetcode.binary_search;

import java.util.Arrays;

public class Search2DMatrix2 {
    
    /**
     * Recursive: O(m + n) time.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        return search(matrix, target, 0, matrix[0].length - 1);
    }
    
    private boolean search(int[][]matrix, int target, int i, int j) {
        if (i == matrix.length || j < 0) return false;
        
        if (matrix[i][j] > target)
            return search(matrix, target, i, j - 1);
        else if (matrix[i][j] < target) 
            return search(matrix, target, i + 1, j);
        
        return true;
    }
    
    /**
     * Not so lazy solution: O(m + n) time.
     */
    public boolean searchMatrix_var2(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0)
            if (matrix[i][j] > target)
                j--;
            else if (matrix[i][j] < target) 
                i++;
            else 
                return true;

        return false;
    }

    /**
     * Lazy solution, O(m.log(n)) time.
     */
    public boolean searchMatrix_var1(int[][] matrix, int target) {
        for (int[] row : matrix)
            if (Arrays.binarySearch(row, target) >= 0)
                return true;

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix2 sln = new Search2DMatrix2();
        int[][] matrix = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
          };
          
      System.out.println(sln.searchMatrix(matrix, 14));
          
    }

}
